package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BullionDeliveryLocation;
import fpml.confirmation.BullionPhysicalLeg;
import fpml.confirmation.BullionPhysicalLeg.BullionPhysicalLegBuilder;
import fpml.confirmation.BullionPhysicalLeg.BullionPhysicalLegBuilderImpl;
import fpml.confirmation.BullionPhysicalLeg.BullionPhysicalLegImpl;
import fpml.confirmation.BullionTypeEnum;
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PhysicalForwardLeg;
import fpml.confirmation.PhysicalForwardLeg.PhysicalForwardLegBuilder;
import fpml.confirmation.PhysicalForwardLeg.PhysicalForwardLegBuilderImpl;
import fpml.confirmation.PhysicalForwardLeg.PhysicalForwardLegImpl;
import fpml.confirmation.meta.BullionPhysicalLegMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The physical leg of a Commodity Forward Transaction for which the underlyer is Bullion. Physically settled leg of a physically settled Bullion Transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="BullionPhysicalLeg", builder=BullionPhysicalLeg.BullionPhysicalLegBuilderImpl.class, version="${project.version}")
public interface BullionPhysicalLeg extends PhysicalForwardLeg {

	BullionPhysicalLegMeta metaData = new BullionPhysicalLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of Bullion underlying a Bullion Transaction.
	 */
	BullionTypeEnum getBullionType();
	/**
	 * The physical delivery location for the transaction.
	 */
	BullionDeliveryLocation getDeliveryLocation();
	CommodityFixedPhysicalQuantityModel getCommodityFixedPhysicalQuantityModel();
	/**
	 * Date on which the bullion will settle.
	 */
	AdjustableOrRelativeDate getSettlementDate();

	/*********************** Build Methods  ***********************/
	BullionPhysicalLeg build();
	
	BullionPhysicalLeg.BullionPhysicalLegBuilder toBuilder();
	
	static BullionPhysicalLeg.BullionPhysicalLegBuilder builder() {
		return new BullionPhysicalLeg.BullionPhysicalLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BullionPhysicalLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BullionPhysicalLeg> getType() {
		return BullionPhysicalLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processor.processBasic(path.newSubPath("bullionType"), BullionTypeEnum.class, getBullionType(), this);
		processRosetta(path.newSubPath("deliveryLocation"), processor, BullionDeliveryLocation.class, getDeliveryLocation());
		processRosetta(path.newSubPath("commodityFixedPhysicalQuantityModel"), processor, CommodityFixedPhysicalQuantityModel.class, getCommodityFixedPhysicalQuantityModel());
		processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.class, getSettlementDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BullionPhysicalLegBuilder extends BullionPhysicalLeg, PhysicalForwardLeg.PhysicalForwardLegBuilder {
		BullionDeliveryLocation.BullionDeliveryLocationBuilder getOrCreateDeliveryLocation();
		BullionDeliveryLocation.BullionDeliveryLocationBuilder getDeliveryLocation();
		CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getOrCreateCommodityFixedPhysicalQuantityModel();
		CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getCommodityFixedPhysicalQuantityModel();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate();
		BullionPhysicalLeg.BullionPhysicalLegBuilder setId(String id);
		BullionPhysicalLeg.BullionPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		BullionPhysicalLeg.BullionPhysicalLegBuilder setBullionType(BullionTypeEnum bullionType);
		BullionPhysicalLeg.BullionPhysicalLegBuilder setDeliveryLocation(BullionDeliveryLocation deliveryLocation);
		BullionPhysicalLeg.BullionPhysicalLegBuilder setCommodityFixedPhysicalQuantityModel(CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel);
		BullionPhysicalLeg.BullionPhysicalLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processor.processBasic(path.newSubPath("bullionType"), BullionTypeEnum.class, getBullionType(), this);
			processRosetta(path.newSubPath("deliveryLocation"), processor, BullionDeliveryLocation.BullionDeliveryLocationBuilder.class, getDeliveryLocation());
			processRosetta(path.newSubPath("commodityFixedPhysicalQuantityModel"), processor, CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder.class, getCommodityFixedPhysicalQuantityModel());
			processRosetta(path.newSubPath("settlementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getSettlementDate());
		}
		

		BullionPhysicalLeg.BullionPhysicalLegBuilder prune();
	}

	/*********************** Immutable Implementation of BullionPhysicalLeg  ***********************/
	class BullionPhysicalLegImpl extends PhysicalForwardLeg.PhysicalForwardLegImpl implements BullionPhysicalLeg {
		private final BullionTypeEnum bullionType;
		private final BullionDeliveryLocation deliveryLocation;
		private final CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel;
		private final AdjustableOrRelativeDate settlementDate;
		
		protected BullionPhysicalLegImpl(BullionPhysicalLeg.BullionPhysicalLegBuilder builder) {
			super(builder);
			this.bullionType = builder.getBullionType();
			this.deliveryLocation = ofNullable(builder.getDeliveryLocation()).map(f->f.build()).orElse(null);
			this.commodityFixedPhysicalQuantityModel = ofNullable(builder.getCommodityFixedPhysicalQuantityModel()).map(f->f.build()).orElse(null);
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("bullionType")
		public BullionTypeEnum getBullionType() {
			return bullionType;
		}
		
		@Override
		@RosettaAttribute("deliveryLocation")
		public BullionDeliveryLocation getDeliveryLocation() {
			return deliveryLocation;
		}
		
		@Override
		@RosettaAttribute("commodityFixedPhysicalQuantityModel")
		public CommodityFixedPhysicalQuantityModel getCommodityFixedPhysicalQuantityModel() {
			return commodityFixedPhysicalQuantityModel;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public AdjustableOrRelativeDate getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public BullionPhysicalLeg build() {
			return this;
		}
		
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder toBuilder() {
			BullionPhysicalLeg.BullionPhysicalLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BullionPhysicalLeg.BullionPhysicalLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBullionType()).ifPresent(builder::setBullionType);
			ofNullable(getDeliveryLocation()).ifPresent(builder::setDeliveryLocation);
			ofNullable(getCommodityFixedPhysicalQuantityModel()).ifPresent(builder::setCommodityFixedPhysicalQuantityModel);
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BullionPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(bullionType, _that.getBullionType())) return false;
			if (!Objects.equals(deliveryLocation, _that.getDeliveryLocation())) return false;
			if (!Objects.equals(commodityFixedPhysicalQuantityModel, _that.getCommodityFixedPhysicalQuantityModel())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (bullionType != null ? bullionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryLocation != null ? deliveryLocation.hashCode() : 0);
			_result = 31 * _result + (commodityFixedPhysicalQuantityModel != null ? commodityFixedPhysicalQuantityModel.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BullionPhysicalLeg {" +
				"bullionType=" + this.bullionType + ", " +
				"deliveryLocation=" + this.deliveryLocation + ", " +
				"commodityFixedPhysicalQuantityModel=" + this.commodityFixedPhysicalQuantityModel + ", " +
				"settlementDate=" + this.settlementDate +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of BullionPhysicalLeg  ***********************/
	class BullionPhysicalLegBuilderImpl extends PhysicalForwardLeg.PhysicalForwardLegBuilderImpl  implements BullionPhysicalLeg.BullionPhysicalLegBuilder {
	
		protected BullionTypeEnum bullionType;
		protected BullionDeliveryLocation.BullionDeliveryLocationBuilder deliveryLocation;
		protected CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder commodityFixedPhysicalQuantityModel;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder settlementDate;
	
		public BullionPhysicalLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("bullionType")
		public BullionTypeEnum getBullionType() {
			return bullionType;
		}
		
		@Override
		@RosettaAttribute("deliveryLocation")
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder getDeliveryLocation() {
			return deliveryLocation;
		}
		
		@Override
		public BullionDeliveryLocation.BullionDeliveryLocationBuilder getOrCreateDeliveryLocation() {
			BullionDeliveryLocation.BullionDeliveryLocationBuilder result;
			if (deliveryLocation!=null) {
				result = deliveryLocation;
			}
			else {
				result = deliveryLocation = BullionDeliveryLocation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityFixedPhysicalQuantityModel")
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getCommodityFixedPhysicalQuantityModel() {
			return commodityFixedPhysicalQuantityModel;
		}
		
		@Override
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getOrCreateCommodityFixedPhysicalQuantityModel() {
			CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder result;
			if (commodityFixedPhysicalQuantityModel!=null) {
				result = commodityFixedPhysicalQuantityModel;
			}
			else {
				result = commodityFixedPhysicalQuantityModel = CommodityFixedPhysicalQuantityModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateSettlementDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("payerReceiverModel")
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("bullionType")
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setBullionType(BullionTypeEnum bullionType) {
			this.bullionType = bullionType==null?null:bullionType;
			return this;
		}
		@Override
		@RosettaAttribute("deliveryLocation")
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setDeliveryLocation(BullionDeliveryLocation deliveryLocation) {
			this.deliveryLocation = deliveryLocation==null?null:deliveryLocation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityFixedPhysicalQuantityModel")
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setCommodityFixedPhysicalQuantityModel(CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel) {
			this.commodityFixedPhysicalQuantityModel = commodityFixedPhysicalQuantityModel==null?null:commodityFixedPhysicalQuantityModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementDate")
		public BullionPhysicalLeg.BullionPhysicalLegBuilder setSettlementDate(AdjustableOrRelativeDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		
		@Override
		public BullionPhysicalLeg build() {
			return new BullionPhysicalLeg.BullionPhysicalLegImpl(this);
		}
		
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder prune() {
			super.prune();
			if (deliveryLocation!=null && !deliveryLocation.prune().hasData()) deliveryLocation = null;
			if (commodityFixedPhysicalQuantityModel!=null && !commodityFixedPhysicalQuantityModel.prune().hasData()) commodityFixedPhysicalQuantityModel = null;
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBullionType()!=null) return true;
			if (getDeliveryLocation()!=null && getDeliveryLocation().hasData()) return true;
			if (getCommodityFixedPhysicalQuantityModel()!=null && getCommodityFixedPhysicalQuantityModel().hasData()) return true;
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BullionPhysicalLeg.BullionPhysicalLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			BullionPhysicalLeg.BullionPhysicalLegBuilder o = (BullionPhysicalLeg.BullionPhysicalLegBuilder) other;
			
			merger.mergeRosetta(getDeliveryLocation(), o.getDeliveryLocation(), this::setDeliveryLocation);
			merger.mergeRosetta(getCommodityFixedPhysicalQuantityModel(), o.getCommodityFixedPhysicalQuantityModel(), this::setCommodityFixedPhysicalQuantityModel);
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			
			merger.mergeBasic(getBullionType(), o.getBullionType(), this::setBullionType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			BullionPhysicalLeg _that = getType().cast(o);
		
			if (!Objects.equals(bullionType, _that.getBullionType())) return false;
			if (!Objects.equals(deliveryLocation, _that.getDeliveryLocation())) return false;
			if (!Objects.equals(commodityFixedPhysicalQuantityModel, _that.getCommodityFixedPhysicalQuantityModel())) return false;
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (bullionType != null ? bullionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (deliveryLocation != null ? deliveryLocation.hashCode() : 0);
			_result = 31 * _result + (commodityFixedPhysicalQuantityModel != null ? commodityFixedPhysicalQuantityModel.hashCode() : 0);
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BullionPhysicalLegBuilder {" +
				"bullionType=" + this.bullionType + ", " +
				"deliveryLocation=" + this.deliveryLocation + ", " +
				"commodityFixedPhysicalQuantityModel=" + this.commodityFixedPhysicalQuantityModel + ", " +
				"settlementDate=" + this.settlementDate +
			'}' + " " + super.toString();
		}
	}
}
