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
import fpml.confirmation.AveragingMethodEnum;
import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.FloatingRateCalculation.FloatingRateCalculationBuilder;
import fpml.confirmation.FloatingRateCalculation.FloatingRateCalculationBuilderImpl;
import fpml.confirmation.FloatingRateCalculation.FloatingRateCalculationImpl;
import fpml.confirmation.FloatingRateIndexModel;
import fpml.confirmation.InflationRateCalculation;
import fpml.confirmation.InflationRateCalculation.InflationRateCalculationBuilder;
import fpml.confirmation.InflationRateCalculation.InflationRateCalculationBuilderImpl;
import fpml.confirmation.InflationRateCalculation.InflationRateCalculationImpl;
import fpml.confirmation.InterpolationMethod;
import fpml.confirmation.MainPublication;
import fpml.confirmation.NegativeInterestRateTreatmentEnum;
import fpml.confirmation.Offset;
import fpml.confirmation.RateSourcePage;
import fpml.confirmation.RateTreatmentEnum;
import fpml.confirmation.Rounding;
import fpml.confirmation.Schedule;
import fpml.confirmation.SpreadSchedule;
import fpml.confirmation.StrikeSchedule;
import fpml.confirmation.meta.InflationRateCalculationMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An inflation rate calculation definition. A type defining the components specifiying an Inflation Rate Calculation
 * @version ${project.version}
 */
@RosettaDataType(value="InflationRateCalculation", builder=InflationRateCalculation.InflationRateCalculationBuilderImpl.class, version="${project.version}")
public interface InflationRateCalculation extends FloatingRateCalculation {

	InflationRateCalculationMeta metaData = new InflationRateCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * an offsetting period from the payment date which determines the reference period for which the inflation index is onserved.
	 */
	Offset getInflationLag();
	/**
	 * The reference source such as Reuters or Bloomberg.
	 */
	RateSourcePage getIndexSource();
	/**
	 * The current main publication source such as relevant web site or a government body.
	 */
	MainPublication getMainPublication();
	/**
	 * The method used when calculating the Inflation Index Level from multiple points - the most common is Linear.
	 */
	InterpolationMethod getInterpolationMethod();
	/**
	 * initial known index level for the first calculation period.
	 */
	BigDecimal getInitialIndexLevel();
	/**
	 * The applicability of a fallback bond as defined in the 2006 ISDA Inflation Derivatives Definitions, sections 1.3 and 1.8.
	 */
	Boolean getFallbackBondApplicable();

	/*********************** Build Methods  ***********************/
	InflationRateCalculation build();
	
	InflationRateCalculation.InflationRateCalculationBuilder toBuilder();
	
	static InflationRateCalculation.InflationRateCalculationBuilder builder() {
		return new InflationRateCalculation.InflationRateCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InflationRateCalculation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InflationRateCalculation> getType() {
		return InflationRateCalculation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("floatingRateIndexModel"), processor, FloatingRateIndexModel.class, getFloatingRateIndexModel());
		processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.class, getFloatingRateMultiplierSchedule());
		processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.class, getSpreadSchedule());
		processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
		processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.class, getCapRateSchedule());
		processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.class, getFloorRateSchedule());
		processor.processBasic(path.newSubPath("initialRate"), BigDecimal.class, getInitialRate(), this);
		processRosetta(path.newSubPath("finalRateRounding"), processor, Rounding.class, getFinalRateRounding());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processor.processBasic(path.newSubPath("negativeInterestRateTreatment"), NegativeInterestRateTreatmentEnum.class, getNegativeInterestRateTreatment(), this);
		processRosetta(path.newSubPath("inflationLag"), processor, Offset.class, getInflationLag());
		processRosetta(path.newSubPath("indexSource"), processor, RateSourcePage.class, getIndexSource());
		processRosetta(path.newSubPath("mainPublication"), processor, MainPublication.class, getMainPublication());
		processRosetta(path.newSubPath("interpolationMethod"), processor, InterpolationMethod.class, getInterpolationMethod());
		processor.processBasic(path.newSubPath("initialIndexLevel"), BigDecimal.class, getInitialIndexLevel(), this);
		processor.processBasic(path.newSubPath("fallbackBondApplicable"), Boolean.class, getFallbackBondApplicable(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InflationRateCalculationBuilder extends InflationRateCalculation, FloatingRateCalculation.FloatingRateCalculationBuilder {
		Offset.OffsetBuilder getOrCreateInflationLag();
		Offset.OffsetBuilder getInflationLag();
		RateSourcePage.RateSourcePageBuilder getOrCreateIndexSource();
		RateSourcePage.RateSourcePageBuilder getIndexSource();
		MainPublication.MainPublicationBuilder getOrCreateMainPublication();
		MainPublication.MainPublicationBuilder getMainPublication();
		InterpolationMethod.InterpolationMethodBuilder getOrCreateInterpolationMethod();
		InterpolationMethod.InterpolationMethodBuilder getInterpolationMethod();
		InflationRateCalculation.InflationRateCalculationBuilder setId(String id);
		InflationRateCalculation.InflationRateCalculationBuilder setFloatingRateIndexModel(FloatingRateIndexModel floatingRateIndexModel);
		InflationRateCalculation.InflationRateCalculationBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule);
		InflationRateCalculation.InflationRateCalculationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule0);
		InflationRateCalculation.InflationRateCalculationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule1, int _idx);
		InflationRateCalculation.InflationRateCalculationBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule2);
		InflationRateCalculation.InflationRateCalculationBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule3);
		InflationRateCalculation.InflationRateCalculationBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		InflationRateCalculation.InflationRateCalculationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule0);
		InflationRateCalculation.InflationRateCalculationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule1, int _idx);
		InflationRateCalculation.InflationRateCalculationBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule2);
		InflationRateCalculation.InflationRateCalculationBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule3);
		InflationRateCalculation.InflationRateCalculationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule0);
		InflationRateCalculation.InflationRateCalculationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule1, int _idx);
		InflationRateCalculation.InflationRateCalculationBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule2);
		InflationRateCalculation.InflationRateCalculationBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule3);
		InflationRateCalculation.InflationRateCalculationBuilder setInitialRate(BigDecimal initialRate);
		InflationRateCalculation.InflationRateCalculationBuilder setFinalRateRounding(Rounding finalRateRounding);
		InflationRateCalculation.InflationRateCalculationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		InflationRateCalculation.InflationRateCalculationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment);
		InflationRateCalculation.InflationRateCalculationBuilder setInflationLag(Offset inflationLag);
		InflationRateCalculation.InflationRateCalculationBuilder setIndexSource(RateSourcePage indexSource);
		InflationRateCalculation.InflationRateCalculationBuilder setMainPublication(MainPublication mainPublication);
		InflationRateCalculation.InflationRateCalculationBuilder setInterpolationMethod(InterpolationMethod interpolationMethod);
		InflationRateCalculation.InflationRateCalculationBuilder setInitialIndexLevel(BigDecimal initialIndexLevel);
		InflationRateCalculation.InflationRateCalculationBuilder setFallbackBondApplicable(Boolean fallbackBondApplicable);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("floatingRateIndexModel"), processor, FloatingRateIndexModel.FloatingRateIndexModelBuilder.class, getFloatingRateIndexModel());
			processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.ScheduleBuilder.class, getFloatingRateMultiplierSchedule());
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
			processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
			processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getCapRateSchedule());
			processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getFloorRateSchedule());
			processor.processBasic(path.newSubPath("initialRate"), BigDecimal.class, getInitialRate(), this);
			processRosetta(path.newSubPath("finalRateRounding"), processor, Rounding.RoundingBuilder.class, getFinalRateRounding());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processor.processBasic(path.newSubPath("negativeInterestRateTreatment"), NegativeInterestRateTreatmentEnum.class, getNegativeInterestRateTreatment(), this);
			processRosetta(path.newSubPath("inflationLag"), processor, Offset.OffsetBuilder.class, getInflationLag());
			processRosetta(path.newSubPath("indexSource"), processor, RateSourcePage.RateSourcePageBuilder.class, getIndexSource());
			processRosetta(path.newSubPath("mainPublication"), processor, MainPublication.MainPublicationBuilder.class, getMainPublication());
			processRosetta(path.newSubPath("interpolationMethod"), processor, InterpolationMethod.InterpolationMethodBuilder.class, getInterpolationMethod());
			processor.processBasic(path.newSubPath("initialIndexLevel"), BigDecimal.class, getInitialIndexLevel(), this);
			processor.processBasic(path.newSubPath("fallbackBondApplicable"), Boolean.class, getFallbackBondApplicable(), this);
		}
		

		InflationRateCalculation.InflationRateCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of InflationRateCalculation  ***********************/
	class InflationRateCalculationImpl extends FloatingRateCalculation.FloatingRateCalculationImpl implements InflationRateCalculation {
		private final Offset inflationLag;
		private final RateSourcePage indexSource;
		private final MainPublication mainPublication;
		private final InterpolationMethod interpolationMethod;
		private final BigDecimal initialIndexLevel;
		private final Boolean fallbackBondApplicable;
		
		protected InflationRateCalculationImpl(InflationRateCalculation.InflationRateCalculationBuilder builder) {
			super(builder);
			this.inflationLag = ofNullable(builder.getInflationLag()).map(f->f.build()).orElse(null);
			this.indexSource = ofNullable(builder.getIndexSource()).map(f->f.build()).orElse(null);
			this.mainPublication = ofNullable(builder.getMainPublication()).map(f->f.build()).orElse(null);
			this.interpolationMethod = ofNullable(builder.getInterpolationMethod()).map(f->f.build()).orElse(null);
			this.initialIndexLevel = builder.getInitialIndexLevel();
			this.fallbackBondApplicable = builder.getFallbackBondApplicable();
		}
		
		@Override
		@RosettaAttribute("inflationLag")
		public Offset getInflationLag() {
			return inflationLag;
		}
		
		@Override
		@RosettaAttribute("indexSource")
		public RateSourcePage getIndexSource() {
			return indexSource;
		}
		
		@Override
		@RosettaAttribute("mainPublication")
		public MainPublication getMainPublication() {
			return mainPublication;
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		public InterpolationMethod getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		@RosettaAttribute("initialIndexLevel")
		public BigDecimal getInitialIndexLevel() {
			return initialIndexLevel;
		}
		
		@Override
		@RosettaAttribute("fallbackBondApplicable")
		public Boolean getFallbackBondApplicable() {
			return fallbackBondApplicable;
		}
		
		@Override
		public InflationRateCalculation build() {
			return this;
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder toBuilder() {
			InflationRateCalculation.InflationRateCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InflationRateCalculation.InflationRateCalculationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInflationLag()).ifPresent(builder::setInflationLag);
			ofNullable(getIndexSource()).ifPresent(builder::setIndexSource);
			ofNullable(getMainPublication()).ifPresent(builder::setMainPublication);
			ofNullable(getInterpolationMethod()).ifPresent(builder::setInterpolationMethod);
			ofNullable(getInitialIndexLevel()).ifPresent(builder::setInitialIndexLevel);
			ofNullable(getFallbackBondApplicable()).ifPresent(builder::setFallbackBondApplicable);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InflationRateCalculation _that = getType().cast(o);
		
			if (!Objects.equals(inflationLag, _that.getInflationLag())) return false;
			if (!Objects.equals(indexSource, _that.getIndexSource())) return false;
			if (!Objects.equals(mainPublication, _that.getMainPublication())) return false;
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(initialIndexLevel, _that.getInitialIndexLevel())) return false;
			if (!Objects.equals(fallbackBondApplicable, _that.getFallbackBondApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inflationLag != null ? inflationLag.hashCode() : 0);
			_result = 31 * _result + (indexSource != null ? indexSource.hashCode() : 0);
			_result = 31 * _result + (mainPublication != null ? mainPublication.hashCode() : 0);
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (initialIndexLevel != null ? initialIndexLevel.hashCode() : 0);
			_result = 31 * _result + (fallbackBondApplicable != null ? fallbackBondApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InflationRateCalculation {" +
				"inflationLag=" + this.inflationLag + ", " +
				"indexSource=" + this.indexSource + ", " +
				"mainPublication=" + this.mainPublication + ", " +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"initialIndexLevel=" + this.initialIndexLevel + ", " +
				"fallbackBondApplicable=" + this.fallbackBondApplicable +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InflationRateCalculation  ***********************/
	class InflationRateCalculationBuilderImpl extends FloatingRateCalculation.FloatingRateCalculationBuilderImpl  implements InflationRateCalculation.InflationRateCalculationBuilder {
	
		protected Offset.OffsetBuilder inflationLag;
		protected RateSourcePage.RateSourcePageBuilder indexSource;
		protected MainPublication.MainPublicationBuilder mainPublication;
		protected InterpolationMethod.InterpolationMethodBuilder interpolationMethod;
		protected BigDecimal initialIndexLevel;
		protected Boolean fallbackBondApplicable;
	
		public InflationRateCalculationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("inflationLag")
		public Offset.OffsetBuilder getInflationLag() {
			return inflationLag;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateInflationLag() {
			Offset.OffsetBuilder result;
			if (inflationLag!=null) {
				result = inflationLag;
			}
			else {
				result = inflationLag = Offset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("indexSource")
		public RateSourcePage.RateSourcePageBuilder getIndexSource() {
			return indexSource;
		}
		
		@Override
		public RateSourcePage.RateSourcePageBuilder getOrCreateIndexSource() {
			RateSourcePage.RateSourcePageBuilder result;
			if (indexSource!=null) {
				result = indexSource;
			}
			else {
				result = indexSource = RateSourcePage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mainPublication")
		public MainPublication.MainPublicationBuilder getMainPublication() {
			return mainPublication;
		}
		
		@Override
		public MainPublication.MainPublicationBuilder getOrCreateMainPublication() {
			MainPublication.MainPublicationBuilder result;
			if (mainPublication!=null) {
				result = mainPublication;
			}
			else {
				result = mainPublication = MainPublication.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		public InterpolationMethod.InterpolationMethodBuilder getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		public InterpolationMethod.InterpolationMethodBuilder getOrCreateInterpolationMethod() {
			InterpolationMethod.InterpolationMethodBuilder result;
			if (interpolationMethod!=null) {
				result = interpolationMethod;
			}
			else {
				result = interpolationMethod = InterpolationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialIndexLevel")
		public BigDecimal getInitialIndexLevel() {
			return initialIndexLevel;
		}
		
		@Override
		@RosettaAttribute("fallbackBondApplicable")
		public Boolean getFallbackBondApplicable() {
			return fallbackBondApplicable;
		}
		
		@Override
		@RosettaAttribute("id")
		public InflationRateCalculation.InflationRateCalculationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateIndexModel")
		public InflationRateCalculation.InflationRateCalculationBuilder setFloatingRateIndexModel(FloatingRateIndexModel floatingRateIndexModel) {
			this.floatingRateIndexModel = floatingRateIndexModel==null?null:floatingRateIndexModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateMultiplierSchedule")
		public InflationRateCalculation.InflationRateCalculationBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = floatingRateMultiplierSchedule==null?null:floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("spreadSchedule")
		public InflationRateCalculation.InflationRateCalculationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule) {
			if (spreadSchedule!=null) this.spreadSchedule.add(spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int _idx) {
			getIndex(this.spreadSchedule, _idx, () -> spreadSchedule.toBuilder());
			return this;
		}
		@Override 
		public InflationRateCalculation.InflationRateCalculationBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (SpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public InflationRateCalculation.InflationRateCalculationBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules == null)  {
				this.spreadSchedule = new ArrayList<>();
			}
			else {
				this.spreadSchedule = spreadSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("rateTreatment")
		public InflationRateCalculation.InflationRateCalculationBuilder setRateTreatment(RateTreatmentEnum rateTreatment) {
			this.rateTreatment = rateTreatment==null?null:rateTreatment;
			return this;
		}
		@Override
		@RosettaAttribute("capRateSchedule")
		public InflationRateCalculation.InflationRateCalculationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule) {
			if (capRateSchedule!=null) this.capRateSchedule.add(capRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int _idx) {
			getIndex(this.capRateSchedule, _idx, () -> capRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public InflationRateCalculation.InflationRateCalculationBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules != null) {
				for (StrikeSchedule toAdd : capRateSchedules) {
					this.capRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public InflationRateCalculation.InflationRateCalculationBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules == null)  {
				this.capRateSchedule = new ArrayList<>();
			}
			else {
				this.capRateSchedule = capRateSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("floorRateSchedule")
		public InflationRateCalculation.InflationRateCalculationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule) {
			if (floorRateSchedule!=null) this.floorRateSchedule.add(floorRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int _idx) {
			getIndex(this.floorRateSchedule, _idx, () -> floorRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public InflationRateCalculation.InflationRateCalculationBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules != null) {
				for (StrikeSchedule toAdd : floorRateSchedules) {
					this.floorRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public InflationRateCalculation.InflationRateCalculationBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules == null)  {
				this.floorRateSchedule = new ArrayList<>();
			}
			else {
				this.floorRateSchedule = floorRateSchedules.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("initialRate")
		public InflationRateCalculation.InflationRateCalculationBuilder setInitialRate(BigDecimal initialRate) {
			this.initialRate = initialRate==null?null:initialRate;
			return this;
		}
		@Override
		@RosettaAttribute("finalRateRounding")
		public InflationRateCalculation.InflationRateCalculationBuilder setFinalRateRounding(Rounding finalRateRounding) {
			this.finalRateRounding = finalRateRounding==null?null:finalRateRounding.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("averagingMethod")
		public InflationRateCalculation.InflationRateCalculationBuilder setAveragingMethod(AveragingMethodEnum averagingMethod) {
			this.averagingMethod = averagingMethod==null?null:averagingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("negativeInterestRateTreatment")
		public InflationRateCalculation.InflationRateCalculationBuilder setNegativeInterestRateTreatment(NegativeInterestRateTreatmentEnum negativeInterestRateTreatment) {
			this.negativeInterestRateTreatment = negativeInterestRateTreatment==null?null:negativeInterestRateTreatment;
			return this;
		}
		@Override
		@RosettaAttribute("inflationLag")
		public InflationRateCalculation.InflationRateCalculationBuilder setInflationLag(Offset inflationLag) {
			this.inflationLag = inflationLag==null?null:inflationLag.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("indexSource")
		public InflationRateCalculation.InflationRateCalculationBuilder setIndexSource(RateSourcePage indexSource) {
			this.indexSource = indexSource==null?null:indexSource.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("mainPublication")
		public InflationRateCalculation.InflationRateCalculationBuilder setMainPublication(MainPublication mainPublication) {
			this.mainPublication = mainPublication==null?null:mainPublication.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interpolationMethod")
		public InflationRateCalculation.InflationRateCalculationBuilder setInterpolationMethod(InterpolationMethod interpolationMethod) {
			this.interpolationMethod = interpolationMethod==null?null:interpolationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("initialIndexLevel")
		public InflationRateCalculation.InflationRateCalculationBuilder setInitialIndexLevel(BigDecimal initialIndexLevel) {
			this.initialIndexLevel = initialIndexLevel==null?null:initialIndexLevel;
			return this;
		}
		@Override
		@RosettaAttribute("fallbackBondApplicable")
		public InflationRateCalculation.InflationRateCalculationBuilder setFallbackBondApplicable(Boolean fallbackBondApplicable) {
			this.fallbackBondApplicable = fallbackBondApplicable==null?null:fallbackBondApplicable;
			return this;
		}
		
		@Override
		public InflationRateCalculation build() {
			return new InflationRateCalculation.InflationRateCalculationImpl(this);
		}
		
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder prune() {
			super.prune();
			if (inflationLag!=null && !inflationLag.prune().hasData()) inflationLag = null;
			if (indexSource!=null && !indexSource.prune().hasData()) indexSource = null;
			if (mainPublication!=null && !mainPublication.prune().hasData()) mainPublication = null;
			if (interpolationMethod!=null && !interpolationMethod.prune().hasData()) interpolationMethod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInflationLag()!=null && getInflationLag().hasData()) return true;
			if (getIndexSource()!=null && getIndexSource().hasData()) return true;
			if (getMainPublication()!=null && getMainPublication().hasData()) return true;
			if (getInterpolationMethod()!=null && getInterpolationMethod().hasData()) return true;
			if (getInitialIndexLevel()!=null) return true;
			if (getFallbackBondApplicable()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InflationRateCalculation.InflationRateCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InflationRateCalculation.InflationRateCalculationBuilder o = (InflationRateCalculation.InflationRateCalculationBuilder) other;
			
			merger.mergeRosetta(getInflationLag(), o.getInflationLag(), this::setInflationLag);
			merger.mergeRosetta(getIndexSource(), o.getIndexSource(), this::setIndexSource);
			merger.mergeRosetta(getMainPublication(), o.getMainPublication(), this::setMainPublication);
			merger.mergeRosetta(getInterpolationMethod(), o.getInterpolationMethod(), this::setInterpolationMethod);
			
			merger.mergeBasic(getInitialIndexLevel(), o.getInitialIndexLevel(), this::setInitialIndexLevel);
			merger.mergeBasic(getFallbackBondApplicable(), o.getFallbackBondApplicable(), this::setFallbackBondApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InflationRateCalculation _that = getType().cast(o);
		
			if (!Objects.equals(inflationLag, _that.getInflationLag())) return false;
			if (!Objects.equals(indexSource, _that.getIndexSource())) return false;
			if (!Objects.equals(mainPublication, _that.getMainPublication())) return false;
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(initialIndexLevel, _that.getInitialIndexLevel())) return false;
			if (!Objects.equals(fallbackBondApplicable, _that.getFallbackBondApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inflationLag != null ? inflationLag.hashCode() : 0);
			_result = 31 * _result + (indexSource != null ? indexSource.hashCode() : 0);
			_result = 31 * _result + (mainPublication != null ? mainPublication.hashCode() : 0);
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (initialIndexLevel != null ? initialIndexLevel.hashCode() : 0);
			_result = 31 * _result + (fallbackBondApplicable != null ? fallbackBondApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InflationRateCalculationBuilder {" +
				"inflationLag=" + this.inflationLag + ", " +
				"indexSource=" + this.indexSource + ", " +
				"mainPublication=" + this.mainPublication + ", " +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"initialIndexLevel=" + this.initialIndexLevel + ", " +
				"fallbackBondApplicable=" + this.fallbackBondApplicable +
			'}' + " " + super.toString();
		}
	}
}
