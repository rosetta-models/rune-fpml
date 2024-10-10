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
import fpml.confirmation.DayTypeEnum;
import fpml.confirmation.FxValuationDateOffset;
import fpml.confirmation.FxValuationDateOffset.FxValuationDateOffsetBuilder;
import fpml.confirmation.FxValuationDateOffset.FxValuationDateOffsetBuilderImpl;
import fpml.confirmation.FxValuationDateOffset.FxValuationDateOffsetImpl;
import fpml.confirmation.Offset;
import fpml.confirmation.Offset.OffsetBuilder;
import fpml.confirmation.Offset.OffsetBuilderImpl;
import fpml.confirmation.Offset.OffsetImpl;
import fpml.confirmation.PeriodEnum;
import fpml.confirmation.meta.FxValuationDateOffsetMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Valuation date offset is used in FX Variance Swap and Volatility Swap to always relate the Final Observation Date and can be: [Final Observation Date][The first Business Day following the Final Observation Date]
 * @version ${project.version}
 */
@RosettaDataType(value="FxValuationDateOffset", builder=FxValuationDateOffset.FxValuationDateOffsetBuilderImpl.class, version="${project.version}")
public interface FxValuationDateOffset extends Offset {

	FxValuationDateOffsetMeta metaData = new FxValuationDateOffsetMeta();

	/*********************** Getter Methods  ***********************/
	BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel();

	/*********************** Build Methods  ***********************/
	FxValuationDateOffset build();
	
	FxValuationDateOffset.FxValuationDateOffsetBuilder toBuilder();
	
	static FxValuationDateOffset.FxValuationDateOffsetBuilder builder() {
		return new FxValuationDateOffset.FxValuationDateOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxValuationDateOffset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxValuationDateOffset> getType() {
		return FxValuationDateOffset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
		processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
		processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.class, getBusinessCentersOrReferenceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxValuationDateOffsetBuilder extends FxValuationDateOffset, Offset.OffsetBuilder {
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getOrCreateBusinessCentersOrReferenceModel();
		BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder getBusinessCentersOrReferenceModel();
		FxValuationDateOffset.FxValuationDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier);
		FxValuationDateOffset.FxValuationDateOffsetBuilder setPeriod(PeriodEnum period);
		FxValuationDateOffset.FxValuationDateOffsetBuilder setId(String id);
		FxValuationDateOffset.FxValuationDateOffsetBuilder setDayType(DayTypeEnum dayType);
		FxValuationDateOffset.FxValuationDateOffsetBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("periodMultiplier"), Integer.class, getPeriodMultiplier(), this);
			processor.processBasic(path.newSubPath("period"), PeriodEnum.class, getPeriod(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("dayType"), DayTypeEnum.class, getDayType(), this);
			processRosetta(path.newSubPath("businessCentersOrReferenceModel"), processor, BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder.class, getBusinessCentersOrReferenceModel());
		}
		

		FxValuationDateOffset.FxValuationDateOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of FxValuationDateOffset  ***********************/
	class FxValuationDateOffsetImpl extends Offset.OffsetImpl implements FxValuationDateOffset {
		private final BusinessCentersOrReferenceModel businessCentersOrReferenceModel;
		
		protected FxValuationDateOffsetImpl(FxValuationDateOffset.FxValuationDateOffsetBuilder builder) {
			super(builder);
			this.businessCentersOrReferenceModel = ofNullable(builder.getBusinessCentersOrReferenceModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public BusinessCentersOrReferenceModel getBusinessCentersOrReferenceModel() {
			return businessCentersOrReferenceModel;
		}
		
		@Override
		public FxValuationDateOffset build() {
			return this;
		}
		
		@Override
		public FxValuationDateOffset.FxValuationDateOffsetBuilder toBuilder() {
			FxValuationDateOffset.FxValuationDateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxValuationDateOffset.FxValuationDateOffsetBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBusinessCentersOrReferenceModel()).ifPresent(builder::setBusinessCentersOrReferenceModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxValuationDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxValuationDateOffset {" +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxValuationDateOffset  ***********************/
	class FxValuationDateOffsetBuilderImpl extends Offset.OffsetBuilderImpl  implements FxValuationDateOffset.FxValuationDateOffsetBuilder {
	
		protected BusinessCentersOrReferenceModel.BusinessCentersOrReferenceModelBuilder businessCentersOrReferenceModel;
	
		public FxValuationDateOffsetBuilderImpl() {
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
		@RosettaAttribute("periodMultiplier")
		public FxValuationDateOffset.FxValuationDateOffsetBuilder setPeriodMultiplier(Integer periodMultiplier) {
			this.periodMultiplier = periodMultiplier==null?null:periodMultiplier;
			return this;
		}
		@Override
		@RosettaAttribute("period")
		public FxValuationDateOffset.FxValuationDateOffsetBuilder setPeriod(PeriodEnum period) {
			this.period = period==null?null:period;
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxValuationDateOffset.FxValuationDateOffsetBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("dayType")
		public FxValuationDateOffset.FxValuationDateOffsetBuilder setDayType(DayTypeEnum dayType) {
			this.dayType = dayType==null?null:dayType;
			return this;
		}
		@Override
		@RosettaAttribute("businessCentersOrReferenceModel")
		public FxValuationDateOffset.FxValuationDateOffsetBuilder setBusinessCentersOrReferenceModel(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			this.businessCentersOrReferenceModel = businessCentersOrReferenceModel==null?null:businessCentersOrReferenceModel.toBuilder();
			return this;
		}
		
		@Override
		public FxValuationDateOffset build() {
			return new FxValuationDateOffset.FxValuationDateOffsetImpl(this);
		}
		
		@Override
		public FxValuationDateOffset.FxValuationDateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxValuationDateOffset.FxValuationDateOffsetBuilder prune() {
			super.prune();
			if (businessCentersOrReferenceModel!=null && !businessCentersOrReferenceModel.prune().hasData()) businessCentersOrReferenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBusinessCentersOrReferenceModel()!=null && getBusinessCentersOrReferenceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxValuationDateOffset.FxValuationDateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxValuationDateOffset.FxValuationDateOffsetBuilder o = (FxValuationDateOffset.FxValuationDateOffsetBuilder) other;
			
			merger.mergeRosetta(getBusinessCentersOrReferenceModel(), o.getBusinessCentersOrReferenceModel(), this::setBusinessCentersOrReferenceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxValuationDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(businessCentersOrReferenceModel, _that.getBusinessCentersOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (businessCentersOrReferenceModel != null ? businessCentersOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxValuationDateOffsetBuilder {" +
				"businessCentersOrReferenceModel=" + this.businessCentersOrReferenceModel +
			'}' + " " + super.toString();
		}
	}
}
