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
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import fpml.confirmation.CommodityPayRelativeToEnum;
import fpml.confirmation.CommodityPayRelativeToEvent;
import fpml.confirmation.CommodityRelativePaymentDates;
import fpml.confirmation.CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder;
import fpml.confirmation.CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilderImpl;
import fpml.confirmation.CommodityRelativePaymentDates.CommodityRelativePaymentDatesImpl;
import fpml.confirmation.DateOffset;
import fpml.confirmation.meta.CommodityRelativePaymentDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The Payment Dates of the trade relative to the Calculation Periods.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityRelativePaymentDates", builder=CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilderImpl.class, version="${project.version}")
public interface CommodityRelativePaymentDates extends RosettaModelObject {

	CommodityRelativePaymentDatesMeta metaData = new CommodityRelativePaymentDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether the payment(s) occur relative to a date such as the end of each Calculation Period or the last Pricing Date in each Calculation Period.
	 */
	CommodityPayRelativeToEnum getPayRelativeTo();
	/**
	 * Specifies whether the payment(s) occur relative to the date of a physical event such as issuance of a bill of lading.
	 */
	CommodityPayRelativeToEvent getPayRelativeToEvent();
	CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel();
	/**
	 * Specifies any offset from the adjusted Calculation Period start date, adjusted Calculation Period end date or Calculation Date applicable to each Payment Date.
	 */
	DateOffset getPaymentDaysOffset();
	BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel();
	String getId();

	/*********************** Build Methods  ***********************/
	CommodityRelativePaymentDates build();
	
	CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder toBuilder();
	
	static CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder builder() {
		return new CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityRelativePaymentDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityRelativePaymentDates> getType() {
		return CommodityRelativePaymentDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("payRelativeTo"), CommodityPayRelativeToEnum.class, getPayRelativeTo(), this);
		processRosetta(path.newSubPath("payRelativeToEvent"), processor, CommodityPayRelativeToEvent.class, getPayRelativeToEvent());
		processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.class, getCommodityCalculationPeriodsPointerModel());
		processRosetta(path.newSubPath("paymentDaysOffset"), processor, DateOffset.class, getPaymentDaysOffset());
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityRelativePaymentDatesBuilder extends CommodityRelativePaymentDates, RosettaModelObjectBuilder {
		CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder getOrCreatePayRelativeToEvent();
		CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder getPayRelativeToEvent();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel();
		CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel();
		DateOffset.DateOffsetBuilder getOrCreatePaymentDaysOffset();
		DateOffset.DateOffsetBuilder getPaymentDaysOffset();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel();
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setPayRelativeTo(CommodityPayRelativeToEnum payRelativeTo);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setPayRelativeToEvent(CommodityPayRelativeToEvent payRelativeToEvent);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setPaymentDaysOffset(DateOffset paymentDaysOffset);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("payRelativeTo"), CommodityPayRelativeToEnum.class, getPayRelativeTo(), this);
			processRosetta(path.newSubPath("payRelativeToEvent"), processor, CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder.class, getPayRelativeToEvent());
			processRosetta(path.newSubPath("commodityCalculationPeriodsPointerModel"), processor, CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder.class, getCommodityCalculationPeriodsPointerModel());
			processRosetta(path.newSubPath("paymentDaysOffset"), processor, DateOffset.DateOffsetBuilder.class, getPaymentDaysOffset());
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityRelativePaymentDates  ***********************/
	class CommodityRelativePaymentDatesImpl implements CommodityRelativePaymentDates {
		private final CommodityPayRelativeToEnum payRelativeTo;
		private final CommodityPayRelativeToEvent payRelativeToEvent;
		private final CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel;
		private final DateOffset paymentDaysOffset;
		private final BusinessCentersOrReferenceModel businessCentersOrReferenceModel;
		private final String id;
		
		protected CommodityRelativePaymentDatesImpl(CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder builder) {
			this.payRelativeTo = builder.getPayRelativeTo();
			this.payRelativeToEvent = ofNullable(builder.getPayRelativeToEvent()).map(f->f.build()).orElse(null);
			this.commodityCalculationPeriodsPointerModel = ofNullable(builder.getCommodityCalculationPeriodsPointerModel()).map(f->f.build()).orElse(null);
			this.paymentDaysOffset = ofNullable(builder.getPaymentDaysOffset()).map(f->f.build()).orElse(null);
			this.businessCentersOrReferenceModel = ofNullable(builder.getBusinessCentersOrReferenceModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("payRelativeTo")
		public CommodityPayRelativeToEnum getPayRelativeTo() {
			return payRelativeTo;
		}
		
		@Override
		@RosettaAttribute("payRelativeToEvent")
		public CommodityPayRelativeToEvent getPayRelativeToEvent() {
			return payRelativeToEvent;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		@RosettaAttribute("paymentDaysOffset")
		public DateOffset getPaymentDaysOffset() {
			return paymentDaysOffset;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CommodityRelativePaymentDates build() {
			return this;
		}
		
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder toBuilder() {
			CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder builder) {
			ofNullable(getPayRelativeTo()).ifPresent(builder::setPayRelativeTo);
			ofNullable(getPayRelativeToEvent()).ifPresent(builder::setPayRelativeToEvent);
			ofNullable(getCommodityCalculationPeriodsPointerModel()).ifPresent(builder::setCommodityCalculationPeriodsPointerModel);
			ofNullable(getPaymentDaysOffset()).ifPresent(builder::setPaymentDaysOffset);
			ofNullable(getBusinessCentersOrReferenceModel()).ifPresent(builder::setBusinessCentersOrReferenceModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityRelativePaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(payRelativeTo, _that.getPayRelativeTo())) return false;
			if (!Objects.equals(payRelativeToEvent, _that.getPayRelativeToEvent())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			if (!Objects.equals(paymentDaysOffset, _that.getPaymentDaysOffset())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payRelativeTo != null ? payRelativeTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payRelativeToEvent != null ? payRelativeToEvent.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			_result = 31 * _result + (paymentDaysOffset != null ? paymentDaysOffset.hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityRelativePaymentDates {" +
				"payRelativeTo=" + this.payRelativeTo + ", " +
				"payRelativeToEvent=" + this.payRelativeToEvent + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel + ", " +
				"paymentDaysOffset=" + this.paymentDaysOffset + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityRelativePaymentDates  ***********************/
	class CommodityRelativePaymentDatesBuilderImpl implements CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder {
	
		protected CommodityPayRelativeToEnum payRelativeTo;
		protected CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder payRelativeToEvent;
		protected CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder commodityCalculationPeriodsPointerModel;
		protected DateOffset.DateOffsetBuilder paymentDaysOffset;
		protected BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder businessCentersOrReferenceModel;
		protected String id;
	
		public CommodityRelativePaymentDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payRelativeTo")
		public CommodityPayRelativeToEnum getPayRelativeTo() {
			return payRelativeTo;
		}
		
		@Override
		@RosettaAttribute("payRelativeToEvent")
		public CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder getPayRelativeToEvent() {
			return payRelativeToEvent;
		}
		
		@Override
		public CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder getOrCreatePayRelativeToEvent() {
			CommodityPayRelativeToEvent.CommodityPayRelativeToEventBuilder result;
			if (payRelativeToEvent!=null) {
				result = payRelativeToEvent;
			}
			else {
				result = payRelativeToEvent = CommodityPayRelativeToEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getCommodityCalculationPeriodsPointerModel() {
			return commodityCalculationPeriodsPointerModel;
		}
		
		@Override
		public CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder getOrCreateCommodityCalculationPeriodsPointerModel() {
			CommodityCalculationPeriodsPointerModel.CommodityCalculationPeriodsPointerModelBuilder result;
			if (commodityCalculationPeriodsPointerModel!=null) {
				result = commodityCalculationPeriodsPointerModel;
			}
			else {
				result = commodityCalculationPeriodsPointerModel = CommodityCalculationPeriodsPointerModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDaysOffset")
		public DateOffset.DateOffsetBuilder getPaymentDaysOffset() {
			return paymentDaysOffset;
		}
		
		@Override
		public DateOffset.DateOffsetBuilder getOrCreatePaymentDaysOffset() {
			DateOffset.DateOffsetBuilder result;
			if (paymentDaysOffset!=null) {
				result = paymentDaysOffset;
			}
			else {
				result = paymentDaysOffset = DateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		public BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel() {
			BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder result;
			if (businessCentersOrReferenceModel!=null) {
				result = businessCentersOrReferenceModel;
			}
			else {
				result = businessCentersOrReferenceModel = BusinessCentersOrReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("payRelativeTo")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setPayRelativeTo(CommodityPayRelativeToEnum payRelativeTo) {
			this.payRelativeTo = payRelativeTo==null?null:payRelativeTo;
			return this;
		}
		@Override
		@RosettaAttribute("payRelativeToEvent")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setPayRelativeToEvent(CommodityPayRelativeToEvent payRelativeToEvent) {
			this.payRelativeToEvent = payRelativeToEvent==null?null:payRelativeToEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityCalculationPeriodsPointerModel")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setCommodityCalculationPeriodsPointerModel(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			this.commodityCalculationPeriodsPointerModel = commodityCalculationPeriodsPointerModel==null?null:commodityCalculationPeriodsPointerModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("paymentDaysOffset")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setPaymentDaysOffset(DateOffset paymentDaysOffset) {
			this.paymentDaysOffset = paymentDaysOffset==null?null:paymentDaysOffset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CommodityRelativePaymentDates build() {
			return new CommodityRelativePaymentDates.CommodityRelativePaymentDatesImpl(this);
		}
		
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder prune() {
			if (payRelativeToEvent!=null && !payRelativeToEvent.prune().hasData()) payRelativeToEvent = null;
			if (commodityCalculationPeriodsPointerModel!=null && !commodityCalculationPeriodsPointerModel.prune().hasData()) commodityCalculationPeriodsPointerModel = null;
			if (paymentDaysOffset!=null && !paymentDaysOffset.prune().hasData()) paymentDaysOffset = null;
			if (businessCentersOrReferenceModel!=null && !businessCentersOrReferenceModel.prune().hasData()) businessCentersOrReferenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayRelativeTo()!=null) return true;
			if (getPayRelativeToEvent()!=null && getPayRelativeToEvent().hasData()) return true;
			if (getCommodityCalculationPeriodsPointerModel()!=null && getCommodityCalculationPeriodsPointerModel().hasData()) return true;
			if (getPaymentDaysOffset()!=null && getPaymentDaysOffset().hasData()) return true;
			if (getBusinessCentersOrReferenceModel()!=null && getBusinessCentersOrReferenceModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder o = (CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder) other;
			
			merger.mergeRosetta(getPayRelativeToEvent(), o.getPayRelativeToEvent(), this::setPayRelativeToEvent);
			merger.mergeRosetta(getCommodityCalculationPeriodsPointerModel(), o.getCommodityCalculationPeriodsPointerModel(), this::setCommodityCalculationPeriodsPointerModel);
			merger.mergeRosetta(getPaymentDaysOffset(), o.getPaymentDaysOffset(), this::setPaymentDaysOffset);
			merger.mergeRosetta(getBusinessCentersOrReferenceModel(), o.getBusinessCentersOrReferenceModel(), this::setBusinessCentersOrReferenceModel);
			
			merger.mergeBasic(getPayRelativeTo(), o.getPayRelativeTo(), this::setPayRelativeTo);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityRelativePaymentDates _that = getType().cast(o);
		
			if (!Objects.equals(payRelativeTo, _that.getPayRelativeTo())) return false;
			if (!Objects.equals(payRelativeToEvent, _that.getPayRelativeToEvent())) return false;
			if (!Objects.equals(commodityCalculationPeriodsPointerModel, _that.getCommodityCalculationPeriodsPointerModel())) return false;
			if (!Objects.equals(paymentDaysOffset, _that.getPaymentDaysOffset())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payRelativeTo != null ? payRelativeTo.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payRelativeToEvent != null ? payRelativeToEvent.hashCode() : 0);
			_result = 31 * _result + (commodityCalculationPeriodsPointerModel != null ? commodityCalculationPeriodsPointerModel.hashCode() : 0);
			_result = 31 * _result + (paymentDaysOffset != null ? paymentDaysOffset.hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityRelativePaymentDatesBuilder {" +
				"payRelativeTo=" + this.payRelativeTo + ", " +
				"payRelativeToEvent=" + this.payRelativeToEvent + ", " +
				"commodityCalculationPeriodsPointerModel=" + this.commodityCalculationPeriodsPointerModel + ", " +
				"paymentDaysOffset=" + this.paymentDaysOffset + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
