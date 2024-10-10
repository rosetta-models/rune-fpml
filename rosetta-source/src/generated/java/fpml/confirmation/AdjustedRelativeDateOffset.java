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
import fpml.confirmation.AdjustedRelativeDateOffset;
import fpml.confirmation.AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder;
import fpml.confirmation.AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilderImpl;
import fpml.confirmation.AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetImpl;
import fpml.confirmation.BusinessCentersOrReferenceModel;
import fpml.confirmation.BusinessDayAdjustments;
import fpml.confirmation.BusinessDayConventionEnum;
import fpml.confirmation.DateReference;
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.IdentifiedDate;
import fpml.confirmation.PeriodEnum;
import fpml.confirmation.RelativeDateOffset;
import fpml.confirmation.RelativeDateOffset.RelativeDateOffsetBuilder;
import fpml.confirmation.RelativeDateOffset.RelativeDateOffsetBuilderImpl;
import fpml.confirmation.RelativeDateOffset.RelativeDateOffsetImpl;
import fpml.confirmation.meta.AdjustedRelativeDateOffsetMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a date (referred to as the derived date) as a relative offset from another date (referred to as the anchor date) plus optional date adjustments.
 * @version ${project.version}
 */
@RosettaDataType(value="AdjustedRelativeDateOffset", builder=AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilderImpl.class, version="${project.version}")
public interface AdjustedRelativeDateOffset extends RelativeDateOffset {

	AdjustedRelativeDateOffsetMeta metaData = new AdjustedRelativeDateOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The business day convention and financial business centers used for adjusting the relative date if it would otherwise fall on a day that is not a business date in the specified business centers.
	 */
	BusinessDayAdjustments getRelativeDateAdjustments();

	/*********************** Build Methods  ***********************/
	AdjustedRelativeDateOffset build();
	
	AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder toBuilder();
	
	static AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder() {
		return new AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustedRelativeDateOffset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustedRelativeDateOffset> getType() {
		return AdjustedRelativeDateOffset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
		processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.class, getDateRelativeTo());
		processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.class, getAdjustedDate());
		processRosetta(path.newSubPath("relativeDateAdjustments"), processor, BusinessDayAdjustments.class, getRelativeDateAdjustments());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustedRelativeDateOffsetBuilder extends AdjustedRelativeDateOffset, RelativeDateOffset.RelativeDateOffsetBuilder {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateRelativeDateAdjustments();
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getRelativeDateAdjustments();
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriod(PeriodEnum period);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setId(String id);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDayType(DayTypeEnum dayType);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeTo(DateReference dateRelativeTo);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setAdjustedDate(IdentifiedDate adjustedDate);
		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setRelativeDateAdjustments(BusinessDayAdjustments relativeDateAdjustments);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processor.processBasic(path.newSubPath("businessDayConvention"), BusinessDayConventionEnum.class, getBusinessDayConvention(), this);
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
			processRosetta(path.newSubPath("dateRelativeTo"), processor, DateReference.DateReferenceBuilder.class, getDateRelativeTo());
			processRosetta(path.newSubPath("adjustedDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAdjustedDate());
			processRosetta(path.newSubPath("relativeDateAdjustments"), processor, BusinessDayAdjustments.BusinessDayAdjustmentsBuilder.class, getRelativeDateAdjustments());
		}
		

		AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustedRelativeDateOffset  ***********************/
	class AdjustedRelativeDateOffsetImpl extends RelativeDateOffset.RelativeDateOffsetImpl implements AdjustedRelativeDateOffset {
		private final BusinessDayAdjustments relativeDateAdjustments;
		
		protected AdjustedRelativeDateOffsetImpl(AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder) {
			super(builder);
			this.relativeDateAdjustments = ofNullable(builder.getRelativeDateAdjustments()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("relativeDateAdjustments")
		public BusinessDayAdjustments getRelativeDateAdjustments() {
			return relativeDateAdjustments;
		}
		
		@Override
		public AdjustedRelativeDateOffset build() {
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder toBuilder() {
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRelativeDateAdjustments()).ifPresent(builder::setRelativeDateAdjustments);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AdjustedRelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(relativeDateAdjustments, _that.getRelativeDateAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relativeDateAdjustments != null ? relativeDateAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustedRelativeDateOffset {" +
				"relativeDateAdjustments=" + this.relativeDateAdjustments +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AdjustedRelativeDateOffset  ***********************/
	class AdjustedRelativeDateOffsetBuilderImpl extends RelativeDateOffset.RelativeDateOffsetBuilderImpl  implements AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder {
	
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder relativeDateAdjustments;
	
		public AdjustedRelativeDateOffsetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("relativeDateAdjustments")
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getRelativeDateAdjustments() {
			return relativeDateAdjustments;
		}
		
		@Override
		public BusinessDayAdjustments.BusinessDayAdjustmentsBuilder getOrCreateRelativeDateAdjustments() {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder result;
			if (relativeDateAdjustments!=null) {
				result = relativeDateAdjustments;
			}
			else {
				result = relativeDateAdjustments = BusinessDayAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodMultiplier")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("dayType")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		@RosettaAttribute("businessDayConvention")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessDayConvention(BusinessDayConventionEnum businessDayConvention) {
			this.businessDayConvention = businessDayConvention==null?null:businessDayConvention;
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("dateRelativeTo")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setDateRelativeTo(DateReference dateRelativeTo) {
			this.dateRelativeTo = dateRelativeTo==null?null:dateRelativeTo.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("adjustedDate")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setAdjustedDate(IdentifiedDate adjustedDate) {
			this.adjustedDate = adjustedDate==null?null:adjustedDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeDateAdjustments")
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder setRelativeDateAdjustments(BusinessDayAdjustments relativeDateAdjustments) {
			this.relativeDateAdjustments = relativeDateAdjustments==null?null:relativeDateAdjustments.toBuilder();
			return this;
		}
		
		@Override
		public AdjustedRelativeDateOffset build() {
			return new AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetImpl(this);
		}
		
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder prune() {
			super.prune();
			if (relativeDateAdjustments!=null && !relativeDateAdjustments.prune().hasData()) relativeDateAdjustments = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRelativeDateAdjustments()!=null && getRelativeDateAdjustments().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder o = (AdjustedRelativeDateOffset.AdjustedRelativeDateOffsetBuilder) other;
			
			merger.mergeRosetta(getRelativeDateAdjustments(), o.getRelativeDateAdjustments(), this::setRelativeDateAdjustments);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AdjustedRelativeDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(relativeDateAdjustments, _that.getRelativeDateAdjustments())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (relativeDateAdjustments != null ? relativeDateAdjustments.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustedRelativeDateOffsetBuilder {" +
				"relativeDateAdjustments=" + this.relativeDateAdjustments +
			'}' + " " + super.toString();
		}
	}
}
