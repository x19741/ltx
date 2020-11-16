package spring.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "retirement_layer")
public class RetirementLayer {

    @Id
    @Column(name = "layer_id")
    private Long id;

    @ApiModelProperty(value = "党支部名称")
    @Column(name="layer_designation")
    private String layerDesignation;

    @ApiModelProperty(value = "党支部人数")
    @Column(name="layer_number")
    private Integer layerNumber;

    @ApiModelProperty(value = "流动党员人数")
    @Column(name="layer_flow")
    private Integer layerFlow;

    @ApiModelProperty(value = "职务")
    @Column(name="layer_duty")
    private String layerDuty;

    @ApiModelProperty(value = "职务")
    @Column(name="layer_dutya")
    private String layerDutya;

    @ApiModelProperty(value = "职务")
    @Column(name="layer_dutyb")
    private String layerDutyb;

    @ApiModelProperty(value = "职务")
    @Column(name="layer_dutyc")
    private String layerDutyc;

    @ApiModelProperty(value = "名字")
    @Column(name="layer_monicker")
    private String layerMonicker;

    @ApiModelProperty(value = "名字")
    @Column(name="layer_monickera")
    private String layerMonickera;

    @ApiModelProperty(value = "名字")
    @Column(name="layer_monickerb")
    private String layerMonickerb;

    @ApiModelProperty(value = "名字")
    @Column(name="layer_monickerc")
    private String layerMonickerc;

    @ApiModelProperty(value = "联系方式")
    @Column(name="layer_relation")
    private String layerRelation;

    @ApiModelProperty(value = "联系方式")
    @Column(name="layer_relationa")
    private String layerRelationa;

    @ApiModelProperty(value = "联系方式")
    @Column(name="layer_relationb")
    private String layerRelationb;

    @ApiModelProperty(value = "联系方式")
    @Column(name="layer_relationc")
    private String layerRelationc;

    @ApiModelProperty(value = "名字")
    @Column(name="layer_name")
    private String layerName;

    @ApiModelProperty(value = "名字")
    @Column(name="layer_namea")
    private String layerNamea;

    @ApiModelProperty(value = "名字")
    @Column(name="layer_nameb")
    private String layerNameb;

    @ApiModelProperty(value = "名字")
    @Column(name="layer_namec")
    private String layerNamec;

    @ApiModelProperty(value = "联系方式")
    @Column(name="layer_contact")
    private String layerContact;

    @ApiModelProperty(value = "联系方式")
    @Column(name="layer_contacta")
    private String layerContacta;

    @ApiModelProperty(value = "联系方式")
    @Column(name="layer_contactb")
    private String layerContactb;

    @ApiModelProperty(value = "联系方式")
    @Column(name="layer_contactc")
    private String layerContactc;

}
