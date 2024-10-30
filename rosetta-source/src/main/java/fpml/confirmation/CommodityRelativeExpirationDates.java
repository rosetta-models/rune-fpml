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
import fpml.confirmation.CommodityExpireRelativeToEvent;
import fpml.confirmation.CommodityRelativeExpirationDates;
import fpml.confirmation.CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder;
import fpml.confirmation.CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilderImpl;
import fpml.confirmation.CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesImpl;
import fpml.confirmation.DateOffset;
import fpml.confirmation.meta.CommodityRelativeExpirationDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The Expiration Dates of the trade relative to the Calculation Periods.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityRelativeExpirationDates", builder=CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityRelativeExpirationDates extends RosettaModelObject {

	CommodityRelativeExpirationDatesMeta metaData = new CommodityRelativeExpirationDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether the payment(s) occur relative to the date of a physical event.
	 */
	CommodityExpireRelativeToEvent getExpireRelativeToEvent();
	/**
	 * Specifies any offset from the adjusted Calculation Period start date or adjusted Calculation Period end date applicable to each Payment Date.
	 */
	DateOffset getExpirationDateOffset();
	BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel();
	String getId();

	/*********************** Build Methods  ***********************/
	CommodityRelativeExpirationDates build();
	
	CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder toBuilder();
	
	static CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder builder() {
		return new CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityRelativeExpirationDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityRelativeExpirationDates> getType() {
		return CommodityRelativeExpirationDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("expireRelativeToEvent"), processor, CommodityExpireRelativeToEvent.class, getExpireRelativeToEvent());
		processRosetta(path.newSubPath("expirationDateOffset"), processor, DateOffset.class, getExpirationDateOffset());
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityRelativeExpirationDatesBuilder extends CommodityRelativeExpirationDates, RosettaModelObjectBuilder {
		CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder getOrCreateExpireRelativeToEvent();
		CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder getExpireRelativeToEvent();
		DateOffset.DateOffsetBuilder getOrCreateExpirationDateOffset();
		DateOffset.DateOffsetBuilder getExpirationDateOffset();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel();
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setExpireRelativeToEvent(CommodityExpireRelativeToEvent expireRelativeToEvent);
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setExpirationDateOffset(DateOffset expirationDateOffset);
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("expireRelativeToEvent"), processor, CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder.class, getExpireRelativeToEvent());
			processRosetta(path.newSubPath("expirationDateOffset"), processor, DateOffset.DateOffsetBuilder.class, getExpirationDateOffset());
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityRelativeExpirationDates  ***********************/
	class CommodityRelativeExpirationDatesImpl implements CommodityRelativeExpirationDates {
		private final CommodityExpireRelativeToEvent expireRelativeToEvent;
		private final DateOffset expirationDateOffset;
		private final BusinessCentersOrReferenceModel businessCentersOrReferenceModel;
		private final String id;
		
		protected CommodityRelativeExpirationDatesImpl(CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder builder) {
			this.expireRelativeToEvent = ofNullable(builder.getExpireRelativeToEvent()).map(f->f.build()).orElse(null);
			this.expirationDateOffset = ofNullable(builder.getExpirationDateOffset()).map(f->f.build()).orElse(null);
			this.businessCentersOrReferenceModel = ofNullable(builder.getBusinessCentersOrReferenceModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("expireRelativeToEvent")
		public CommodityExpireRelativeToEvent getExpireRelativeToEvent() {
			return expireRelativeToEvent;
		}
		
		@Override
		@RosettaAttribute("expirationDateOffset")
		public DateOffset getExpirationDateOffset() {
			return expirationDateOffset;
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
		public CommodityRelativeExpirationDates build() {
			return this;
		}
		
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder toBuilder() {
			CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder builder) {
			ofNullable(getExpireRelativeToEvent()).ifPresent(builder::setExpireRelativeToEvent);
			ofNullable(getExpirationDateOffset()).ifPresent(builder::setExpirationDateOffset);
			ofNullable(getBusinessCentersOrReferenceModel()).ifPresent(builder::setBusinessCentersOrReferenceModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityRelativeExpirationDates _that = getType().cast(o);
		
			if (!Objects.equals(expireRelativeToEvent, _that.getExpireRelativeToEvent())) return false;
			if (!Objects.equals(expirationDateOffset, _that.getExpirationDateOffset())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (expireRelativeToEvent != null ? expireRelativeToEvent.hashCode() : 0);
			_result = 31 * _result + (expirationDateOffset != null ? expirationDateOffset.hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityRelativeExpirationDates {" +
				"expireRelativeToEvent=" + this.expireRelativeToEvent + ", " +
				"expirationDateOffset=" + this.expirationDateOffset + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityRelativeExpirationDates  ***********************/
	class CommodityRelativeExpirationDatesBuilderImpl implements CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder {
	
		protected CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder expireRelativeToEvent;
		protected DateOffset.DateOffsetBuilder expirationDateOffset;
		protected BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder businessCentersOrReferenceModel;
		protected String id;
	
		public CommodityRelativeExpirationDatesBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expireRelativeToEvent")
		public CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder getExpireRelativeToEvent() {
			return expireRelativeToEvent;
		}
		
		@Override
		public CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder getOrCreateExpireRelativeToEvent() {
			CommodityExpireRelativeToEvent.CommodityExpireRelativeToEventBuilder result;
			if (expireRelativeToEvent!=null) {
				result = expireRelativeToEvent;
			}
			else {
				result = expireRelativeToEvent = CommodityExpireRelativeToEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationDateOffset")
		public DateOffset.DateOffsetBuilder getExpirationDateOffset() {
			return expirationDateOffset;
		}
		
		@Override
		public DateOffset.DateOffsetBuilder getOrCreateExpirationDateOffset() {
			DateOffset.DateOffsetBuilder result;
			if (expirationDateOffset!=null) {
				result = expirationDateOffset;
			}
			else {
				result = expirationDateOffset = DateOffset.builder();
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
		@RosettaAttribute("expireRelativeToEvent")
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setExpireRelativeToEvent(CommodityExpireRelativeToEvent expireRelativeToEvent) {
			this.expireRelativeToEvent = expireRelativeToEvent==null?null:expireRelativeToEvent.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationDateOffset")
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setExpirationDateOffset(DateOffset expirationDateOffset) {
			this.expirationDateOffset = expirationDateOffset==null?null:expirationDateOffset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CommodityRelativeExpirationDates build() {
			return new CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesImpl(this);
		}
		
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder prune() {
			if (expireRelativeToEvent!=null && !expireRelativeToEvent.prune().hasData()) expireRelativeToEvent = null;
			if (expirationDateOffset!=null && !expirationDateOffset.prune().hasData()) expirationDateOffset = null;
			if (businessCentersOrReferenceModel!=null && !businessCentersOrReferenceModel.prune().hasData()) businessCentersOrReferenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExpireRelativeToEvent()!=null && getExpireRelativeToEvent().hasData()) return true;
			if (getExpirationDateOffset()!=null && getExpirationDateOffset().hasData()) return true;
			if (getBusinessCentersOrReferenceModel()!=null && getBusinessCentersOrReferenceModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder o = (CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder) other;
			
			merger.mergeRosetta(getExpireRelativeToEvent(), o.getExpireRelativeToEvent(), this::setExpireRelativeToEvent);
			merger.mergeRosetta(getExpirationDateOffset(), o.getExpirationDateOffset(), this::setExpirationDateOffset);
			merger.mergeRosetta(getBusinessCentersOrReferenceModel(), o.getBusinessCentersOrReferenceModel(), this::setBusinessCentersOrReferenceModel);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityRelativeExpirationDates _that = getType().cast(o);
		
			if (!Objects.equals(expireRelativeToEvent, _that.getExpireRelativeToEvent())) return false;
			if (!Objects.equals(expirationDateOffset, _that.getExpirationDateOffset())) return false;
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (expireRelativeToEvent != null ? expireRelativeToEvent.hashCode() : 0);
			_result = 31 * _result + (expirationDateOffset != null ? expirationDateOffset.hashCode() : 0);
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityRelativeExpirationDatesBuilder {" +
				"expireRelativeToEvent=" + this.expireRelativeToEvent + ", " +
				"expirationDateOffset=" + this.expirationDateOffset + ", " +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
