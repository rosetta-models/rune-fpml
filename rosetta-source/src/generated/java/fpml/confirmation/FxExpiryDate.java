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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.FxAdjustedDateAndDateAdjustments;
import fpml.confirmation.FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder;
import fpml.confirmation.FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilderImpl;
import fpml.confirmation.FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsImpl;
import fpml.confirmation.FxExpiryDate;
import fpml.confirmation.FxExpiryDate.FxExpiryDateBuilder;
import fpml.confirmation.FxExpiryDate.FxExpiryDateBuilderImpl;
import fpml.confirmation.FxExpiryDate.FxExpiryDateImpl;
import fpml.confirmation.meta.FxExpiryDateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the expiry date of the accrual. The date is adjusted, date adjustments may be provided, and also the expiry time.
 * @version ${project.version}
 */
@RosettaDataType(value="FxExpiryDate", builder=FxExpiryDate.FxExpiryDateBuilderImpl.class, version="${project.version}")
public interface FxExpiryDate extends FxAdjustedDateAndDateAdjustments {

	FxExpiryDateMeta metaData = new FxExpiryDateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Time of expiration of each expiry date.
	 */
	BusinessCenterTime getExpiryTime();

	/*********************** Build Methods  ***********************/
	FxExpiryDate build();
	
	FxExpiryDate.FxExpiryDateBuilder toBuilder();
	
	static FxExpiryDate.FxExpiryDateBuilder builder() {
		return new FxExpiryDate.FxExpiryDateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxExpiryDate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxExpiryDate> getType() {
		return FxExpiryDate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.class, getDateAdjustments());
		processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
		processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.class, getExpiryTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxExpiryDateBuilder extends FxExpiryDate, FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpiryTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getExpiryTime();
		FxExpiryDate.FxExpiryDateBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments);
		FxExpiryDate.FxExpiryDateBuilder setAdjustedDate(Date adjustedDate);
		FxExpiryDate.FxExpiryDateBuilder setExpiryTime(BusinessCenterTime expiryTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("dateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getDateAdjustments());
			processor.processBasic(path.newSubPath("adjustedDate"), Date.class, getAdjustedDate(), this);
			processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpiryTime());
		}
		

		FxExpiryDate.FxExpiryDateBuilder prune();
	}

	/*********************** Immutable Implementation of FxExpiryDate  ***********************/
	class FxExpiryDateImpl extends FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsImpl implements FxExpiryDate {
		private final BusinessCenterTime expiryTime;
		
		protected FxExpiryDateImpl(FxExpiryDate.FxExpiryDateBuilder builder) {
			super(builder);
			this.expiryTime = ofNullable(builder.getExpiryTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("expiryTime")
		public BusinessCenterTime getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		public FxExpiryDate build() {
			return this;
		}
		
		@Override
		public FxExpiryDate.FxExpiryDateBuilder toBuilder() {
			FxExpiryDate.FxExpiryDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxExpiryDate.FxExpiryDateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getExpiryTime()).ifPresent(builder::setExpiryTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxExpiryDate _that = getType().cast(o);
		
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExpiryDate {" +
				"expiryTime=" + this.expiryTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxExpiryDate  ***********************/
	class FxExpiryDateBuilderImpl extends FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilderImpl  implements FxExpiryDate.FxExpiryDateBuilder {
	
		protected BusinessCenterTime.BusinessCenterTimeBuilder expiryTime;
	
		public FxExpiryDateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expiryTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getExpiryTime() {
			return expiryTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExpiryTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (expiryTime!=null) {
				result = expiryTime;
			}
			else {
				result = expiryTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dateAdjustments")
		public FxExpiryDate.FxExpiryDateBuilder setDateAdjustments(BusinessDayAdjustments dateAdjustments) {
			this.dateAdjustments = dateAdjustments==null?null:dateAdjustments.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustedDate")
		public FxExpiryDate.FxExpiryDateBuilder setAdjustedDate(Date adjustedDate) {
			this.adjustedDate = adjustedDate==null?null:adjustedDate;
			return this;
		}
		@Override
		@RosettaAttribute("expiryTime")
		public FxExpiryDate.FxExpiryDateBuilder setExpiryTime(BusinessCenterTime expiryTime) {
			this.expiryTime = expiryTime==null?null:expiryTime.toBuilder();
			return this;
		}
		
		@Override
		public FxExpiryDate build() {
			return new FxExpiryDate.FxExpiryDateImpl(this);
		}
		
		@Override
		public FxExpiryDate.FxExpiryDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExpiryDate.FxExpiryDateBuilder prune() {
			super.prune();
			if (expiryTime!=null && !expiryTime.prune().hasData()) expiryTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getExpiryTime()!=null && getExpiryTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExpiryDate.FxExpiryDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxExpiryDate.FxExpiryDateBuilder o = (FxExpiryDate.FxExpiryDateBuilder) other;
			
			merger.mergeRosetta(getExpiryTime(), o.getExpiryTime(), this::setExpiryTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxExpiryDate _that = getType().cast(o);
		
			if (!Objects.equals(expiryTime, _that.getExpiryTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (expiryTime != null ? expiryTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExpiryDateBuilder {" +
				"expiryTime=" + this.expiryTime +
			'}' + " " + super.toString();
		}
	}
}
