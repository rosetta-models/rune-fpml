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
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.FxAsianFeature;
import fpml.confirmation.FxAsianFeature.FxAsianFeatureBuilder;
import fpml.confirmation.FxAsianFeature.FxAsianFeatureBuilderImpl;
import fpml.confirmation.FxAsianFeature.FxAsianFeatureImpl;
import fpml.confirmation.FxAsianFeatureSequence;
import fpml.confirmation.FxRateObservationModel;
import fpml.confirmation.InformationSource;
import fpml.confirmation.meta.FxAsianFeatureMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Descibes the averaging period properties for an asian option.
 * @version ${project.version}
 */
@RosettaDataType(value="FxAsianFeature", builder=FxAsianFeature.FxAsianFeatureBuilderImpl.class, version="${project.version}")
public interface FxAsianFeature extends RosettaModelObject {

	FxAsianFeatureMeta metaData = new FxAsianFeatureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The primary source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 */
	InformationSource getPrimaryRateSource();
	/**
	 * An alternative, or secondary, source for where the rate observation will occur. Will typically be either a page or a reference bank published rate.
	 */
	InformationSource getSecondaryRateSource();
	/**
	 * The time at which the spot currency exchange rate will be observed. It is specified as a time in a business day calendar location, e.g. 11:00am London time.
	 */
	BusinessCenterTime getFixingTime();
	FxAsianFeatureSequence getFxAsianFeatureSequence();
	FxRateObservationModel getFxRateObservationModel();
	/**
	 * The description of the mathematical computation for how the payout is computed.
	 */
	String getPayoutFormula();
	/**
	 * Specifies the rounding precision in terms of a number of decimal places. Note how a percentage rate rounding of 5 decimal places is expressed as a rounding precision of 7 in the FpML document since the percentage is expressed as a decimal, e.g. 9.876543% (or 0.09876543) being rounded to the nearest 5 decimal places is 9.87654% (or 0.0987654).
	 */
	Integer getPrecision();

	/*********************** Build Methods  ***********************/
	FxAsianFeature build();
	
	FxAsianFeature.FxAsianFeatureBuilder toBuilder();
	
	static FxAsianFeature.FxAsianFeatureBuilder builder() {
		return new FxAsianFeature.FxAsianFeatureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAsianFeature> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAsianFeature> getType() {
		return FxAsianFeature.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.class, getPrimaryRateSource());
		processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.class, getSecondaryRateSource());
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
		processRosetta(path.newSubPath("fxAsianFeatureSequence"), processor, FxAsianFeatureSequence.class, getFxAsianFeatureSequence());
		processRosetta(path.newSubPath("fxRateObservationModel"), processor, FxRateObservationModel.class, getFxRateObservationModel());
		processor.processBasic(path.newSubPath("payoutFormula"), String.class, getPayoutFormula(), this);
		processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAsianFeatureBuilder extends FxAsianFeature, RosettaModelObjectBuilder {
		InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource();
		InformationSource.InformationSourceBuilder getPrimaryRateSource();
		InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource();
		InformationSource.InformationSourceBuilder getSecondaryRateSource();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder getOrCreateFxAsianFeatureSequence();
		FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder getFxAsianFeatureSequence();
		FxRateObservationModel.FxRateObservationModelBuilder getOrCreateFxRateObservationModel();
		FxRateObservationModel.FxRateObservationModelBuilder getFxRateObservationModel();
		FxAsianFeature.FxAsianFeatureBuilder setPrimaryRateSource(InformationSource primaryRateSource);
		FxAsianFeature.FxAsianFeatureBuilder setSecondaryRateSource(InformationSource secondaryRateSource);
		FxAsianFeature.FxAsianFeatureBuilder setFixingTime(BusinessCenterTime fixingTime);
		FxAsianFeature.FxAsianFeatureBuilder setFxAsianFeatureSequence(FxAsianFeatureSequence fxAsianFeatureSequence);
		FxAsianFeature.FxAsianFeatureBuilder setFxRateObservationModel(FxRateObservationModel fxRateObservationModel);
		FxAsianFeature.FxAsianFeatureBuilder setPayoutFormula(String payoutFormula);
		FxAsianFeature.FxAsianFeatureBuilder setPrecision(Integer precision);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("primaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getPrimaryRateSource());
			processRosetta(path.newSubPath("secondaryRateSource"), processor, InformationSource.InformationSourceBuilder.class, getSecondaryRateSource());
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
			processRosetta(path.newSubPath("fxAsianFeatureSequence"), processor, FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder.class, getFxAsianFeatureSequence());
			processRosetta(path.newSubPath("fxRateObservationModel"), processor, FxRateObservationModel.FxRateObservationModelBuilder.class, getFxRateObservationModel());
			processor.processBasic(path.newSubPath("payoutFormula"), String.class, getPayoutFormula(), this);
			processor.processBasic(path.newSubPath("precision"), Integer.class, getPrecision(), this);
		}
		

		FxAsianFeature.FxAsianFeatureBuilder prune();
	}

	/*********************** Immutable Implementation of FxAsianFeature  ***********************/
	class FxAsianFeatureImpl implements FxAsianFeature {
		private final InformationSource primaryRateSource;
		private final InformationSource secondaryRateSource;
		private final BusinessCenterTime fixingTime;
		private final FxAsianFeatureSequence fxAsianFeatureSequence;
		private final FxRateObservationModel fxRateObservationModel;
		private final String payoutFormula;
		private final Integer precision;
		
		protected FxAsianFeatureImpl(FxAsianFeature.FxAsianFeatureBuilder builder) {
			this.primaryRateSource = ofNullable(builder.getPrimaryRateSource()).map(f->f.build()).orElse(null);
			this.secondaryRateSource = ofNullable(builder.getSecondaryRateSource()).map(f->f.build()).orElse(null);
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
			this.fxAsianFeatureSequence = ofNullable(builder.getFxAsianFeatureSequence()).map(f->f.build()).orElse(null);
			this.fxRateObservationModel = ofNullable(builder.getFxRateObservationModel()).map(f->f.build()).orElse(null);
			this.payoutFormula = builder.getPayoutFormula();
			this.precision = builder.getPrecision();
		}
		
		@Override
		@RosettaAttribute("primaryRateSource")
		public InformationSource getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		public InformationSource getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		@RosettaAttribute("fxAsianFeatureSequence")
		public FxAsianFeatureSequence getFxAsianFeatureSequence() {
			return fxAsianFeatureSequence;
		}
		
		@Override
		@RosettaAttribute("fxRateObservationModel")
		public FxRateObservationModel getFxRateObservationModel() {
			return fxRateObservationModel;
		}
		
		@Override
		@RosettaAttribute("payoutFormula")
		public String getPayoutFormula() {
			return payoutFormula;
		}
		
		@Override
		@RosettaAttribute("precision")
		public Integer getPrecision() {
			return precision;
		}
		
		@Override
		public FxAsianFeature build() {
			return this;
		}
		
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder toBuilder() {
			FxAsianFeature.FxAsianFeatureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAsianFeature.FxAsianFeatureBuilder builder) {
			ofNullable(getPrimaryRateSource()).ifPresent(builder::setPrimaryRateSource);
			ofNullable(getSecondaryRateSource()).ifPresent(builder::setSecondaryRateSource);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
			ofNullable(getFxAsianFeatureSequence()).ifPresent(builder::setFxAsianFeatureSequence);
			ofNullable(getFxRateObservationModel()).ifPresent(builder::setFxRateObservationModel);
			ofNullable(getPayoutFormula()).ifPresent(builder::setPayoutFormula);
			ofNullable(getPrecision()).ifPresent(builder::setPrecision);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAsianFeature _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(fxAsianFeatureSequence, _that.getFxAsianFeatureSequence())) return false;
			if (!Objects.equals(fxRateObservationModel, _that.getFxRateObservationModel())) return false;
			if (!Objects.equals(payoutFormula, _that.getPayoutFormula())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (fxAsianFeatureSequence != null ? fxAsianFeatureSequence.hashCode() : 0);
			_result = 31 * _result + (fxRateObservationModel != null ? fxRateObservationModel.hashCode() : 0);
			_result = 31 * _result + (payoutFormula != null ? payoutFormula.hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAsianFeature {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"fxAsianFeatureSequence=" + this.fxAsianFeatureSequence + ", " +
				"fxRateObservationModel=" + this.fxRateObservationModel + ", " +
				"payoutFormula=" + this.payoutFormula + ", " +
				"precision=" + this.precision +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAsianFeature  ***********************/
	class FxAsianFeatureBuilderImpl implements FxAsianFeature.FxAsianFeatureBuilder {
	
		protected InformationSource.InformationSourceBuilder primaryRateSource;
		protected InformationSource.InformationSourceBuilder secondaryRateSource;
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
		protected FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder fxAsianFeatureSequence;
		protected FxRateObservationModel.FxRateObservationModelBuilder fxRateObservationModel;
		protected String payoutFormula;
		protected Integer precision;
	
		public FxAsianFeatureBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("primaryRateSource")
		public InformationSource.InformationSourceBuilder getPrimaryRateSource() {
			return primaryRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreatePrimaryRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (primaryRateSource!=null) {
				result = primaryRateSource;
			}
			else {
				result = primaryRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("secondaryRateSource")
		public InformationSource.InformationSourceBuilder getSecondaryRateSource() {
			return secondaryRateSource;
		}
		
		@Override
		public InformationSource.InformationSourceBuilder getOrCreateSecondaryRateSource() {
			InformationSource.InformationSourceBuilder result;
			if (secondaryRateSource!=null) {
				result = secondaryRateSource;
			}
			else {
				result = secondaryRateSource = InformationSource.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxAsianFeatureSequence")
		public FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder getFxAsianFeatureSequence() {
			return fxAsianFeatureSequence;
		}
		
		@Override
		public FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder getOrCreateFxAsianFeatureSequence() {
			FxAsianFeatureSequence.FxAsianFeatureSequenceBuilder result;
			if (fxAsianFeatureSequence!=null) {
				result = fxAsianFeatureSequence;
			}
			else {
				result = fxAsianFeatureSequence = FxAsianFeatureSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxRateObservationModel")
		public FxRateObservationModel.FxRateObservationModelBuilder getFxRateObservationModel() {
			return fxRateObservationModel;
		}
		
		@Override
		public FxRateObservationModel.FxRateObservationModelBuilder getOrCreateFxRateObservationModel() {
			FxRateObservationModel.FxRateObservationModelBuilder result;
			if (fxRateObservationModel!=null) {
				result = fxRateObservationModel;
			}
			else {
				result = fxRateObservationModel = FxRateObservationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payoutFormula")
		public String getPayoutFormula() {
			return payoutFormula;
		}
		
		@Override
		@RosettaAttribute("precision")
		public Integer getPrecision() {
			return precision;
		}
		
		@Override
		@RosettaAttribute("primaryRateSource")
		public FxAsianFeature.FxAsianFeatureBuilder setPrimaryRateSource(InformationSource primaryRateSource) {
			this.primaryRateSource = primaryRateSource==null?null:primaryRateSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("secondaryRateSource")
		public FxAsianFeature.FxAsianFeatureBuilder setSecondaryRateSource(InformationSource secondaryRateSource) {
			this.secondaryRateSource = secondaryRateSource==null?null:secondaryRateSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingTime")
		public FxAsianFeature.FxAsianFeatureBuilder setFixingTime(BusinessCenterTime fixingTime) {
			this.fixingTime = fixingTime==null?null:fixingTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxAsianFeatureSequence")
		public FxAsianFeature.FxAsianFeatureBuilder setFxAsianFeatureSequence(FxAsianFeatureSequence fxAsianFeatureSequence) {
			this.fxAsianFeatureSequence = fxAsianFeatureSequence==null?null:fxAsianFeatureSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxRateObservationModel")
		public FxAsianFeature.FxAsianFeatureBuilder setFxRateObservationModel(FxRateObservationModel fxRateObservationModel) {
			this.fxRateObservationModel = fxRateObservationModel==null?null:fxRateObservationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payoutFormula")
		public FxAsianFeature.FxAsianFeatureBuilder setPayoutFormula(String payoutFormula) {
			this.payoutFormula = payoutFormula==null?null:payoutFormula;
			return this;
		}
		@Override
		@RosettaAttribute("precision")
		public FxAsianFeature.FxAsianFeatureBuilder setPrecision(Integer precision) {
			this.precision = precision==null?null:precision;
			return this;
		}
		
		@Override
		public FxAsianFeature build() {
			return new FxAsianFeature.FxAsianFeatureImpl(this);
		}
		
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder prune() {
			if (primaryRateSource!=null && !primaryRateSource.prune().hasData()) primaryRateSource = null;
			if (secondaryRateSource!=null && !secondaryRateSource.prune().hasData()) secondaryRateSource = null;
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			if (fxAsianFeatureSequence!=null && !fxAsianFeatureSequence.prune().hasData()) fxAsianFeatureSequence = null;
			if (fxRateObservationModel!=null && !fxRateObservationModel.prune().hasData()) fxRateObservationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrimaryRateSource()!=null && getPrimaryRateSource().hasData()) return true;
			if (getSecondaryRateSource()!=null && getSecondaryRateSource().hasData()) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			if (getFxAsianFeatureSequence()!=null && getFxAsianFeatureSequence().hasData()) return true;
			if (getFxRateObservationModel()!=null && getFxRateObservationModel().hasData()) return true;
			if (getPayoutFormula()!=null) return true;
			if (getPrecision()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAsianFeature.FxAsianFeatureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAsianFeature.FxAsianFeatureBuilder o = (FxAsianFeature.FxAsianFeatureBuilder) other;
			
			merger.mergeRosetta(getPrimaryRateSource(), o.getPrimaryRateSource(), this::setPrimaryRateSource);
			merger.mergeRosetta(getSecondaryRateSource(), o.getSecondaryRateSource(), this::setSecondaryRateSource);
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			merger.mergeRosetta(getFxAsianFeatureSequence(), o.getFxAsianFeatureSequence(), this::setFxAsianFeatureSequence);
			merger.mergeRosetta(getFxRateObservationModel(), o.getFxRateObservationModel(), this::setFxRateObservationModel);
			
			merger.mergeBasic(getPayoutFormula(), o.getPayoutFormula(), this::setPayoutFormula);
			merger.mergeBasic(getPrecision(), o.getPrecision(), this::setPrecision);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAsianFeature _that = getType().cast(o);
		
			if (!Objects.equals(primaryRateSource, _that.getPrimaryRateSource())) return false;
			if (!Objects.equals(secondaryRateSource, _that.getSecondaryRateSource())) return false;
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			if (!Objects.equals(fxAsianFeatureSequence, _that.getFxAsianFeatureSequence())) return false;
			if (!Objects.equals(fxRateObservationModel, _that.getFxRateObservationModel())) return false;
			if (!Objects.equals(payoutFormula, _that.getPayoutFormula())) return false;
			if (!Objects.equals(precision, _that.getPrecision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (primaryRateSource != null ? primaryRateSource.hashCode() : 0);
			_result = 31 * _result + (secondaryRateSource != null ? secondaryRateSource.hashCode() : 0);
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			_result = 31 * _result + (fxAsianFeatureSequence != null ? fxAsianFeatureSequence.hashCode() : 0);
			_result = 31 * _result + (fxRateObservationModel != null ? fxRateObservationModel.hashCode() : 0);
			_result = 31 * _result + (payoutFormula != null ? payoutFormula.hashCode() : 0);
			_result = 31 * _result + (precision != null ? precision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAsianFeatureBuilder {" +
				"primaryRateSource=" + this.primaryRateSource + ", " +
				"secondaryRateSource=" + this.secondaryRateSource + ", " +
				"fixingTime=" + this.fixingTime + ", " +
				"fxAsianFeatureSequence=" + this.fxAsianFeatureSequence + ", " +
				"fxRateObservationModel=" + this.fxRateObservationModel + ", " +
				"payoutFormula=" + this.payoutFormula + ", " +
				"precision=" + this.precision +
			'}';
		}
	}
}
