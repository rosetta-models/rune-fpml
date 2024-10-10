package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.FloatingRate;
import fpml.confirmation.FloatingRate.FloatingRateBuilder;
import fpml.confirmation.FloatingRate.FloatingRateBuilderImpl;
import fpml.confirmation.FloatingRate.FloatingRateImpl;
import fpml.confirmation.FloatingRateIndexModel;
import fpml.confirmation.Rate;
import fpml.confirmation.Rate.RateBuilder;
import fpml.confirmation.Rate.RateBuilderImpl;
import fpml.confirmation.Rate.RateImpl;
import fpml.confirmation.RateTreatmentEnum;
import fpml.confirmation.Schedule;
import fpml.confirmation.SpreadSchedule;
import fpml.confirmation.StrikeSchedule;
import fpml.confirmation.meta.FloatingRateMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining a floating rate.
 * @version ${project.version}
 */
@RosettaDataType(value="FloatingRate", builder=FloatingRate.FloatingRateBuilderImpl.class, version="${project.version}")
public interface FloatingRate extends Rate {

	FloatingRateMeta metaData = new FloatingRateMeta();

	/*********************** Getter Methods  ***********************/
	FloatingRateIndexModel getFloatingRateIndexModel();
	/**
	 * A rate multiplier or multiplier schedule to apply to the floating rate. A multiplier schedule is expressed as explicit multipliers and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in the calculationPeriodDatesAdjustments. The multiplier can be a positive or negative decimal. This element should only be included if the multiplier is not equal to 1 (one) for the term of the stream.
	 */
	Schedule getFloatingRateMultiplierSchedule();
	/**
	 * The ISDA Spread or a Spread schedule expressed as explicit spreads and dates. In the case of a schedule, the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The spread is a per annum rate, expressed as a decimal. For purposes of determining a calculation period amount, if positive the spread will be added to the floating rate and if negative the spread will be subtracted from the floating rate. A positive 10 basis point (0.1%) spread would be represented as 0.001.
	 */
	List<? extends SpreadSchedule> getSpreadSchedule();
	/**
	 * The specification of any rate conversion which needs to be applied to the observed rate before being used in any calculations. The two common conversions are for securities quoted on a bank discount basis which will need to be converted to either a Money Market Yield or Bond Equivalent Yield. See the Annex to the 2000 ISDA Definitions, Section 7.3. Certain General Definitions Relating to Floating Rate Options, paragraphs (g) and (h) for definitions of these terms.
	 */
	RateTreatmentEnum getRateTreatment();
	/**
	 * The cap rate or cap rate schedule, if any, which applies to the floating rate. The cap rate (strike) is only required where the floating rate on a swap stream is capped at a certain level. A cap rate schedule is expressed as explicit cap rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A cap rate of 5% would be represented as 0.05.
	 */
	List<? extends StrikeSchedule> getCapRateSchedule();
	/**
	 * The floor rate or floor rate schedule, if any, which applies to the floating rate. The floor rate (strike) is only required where the floating rate on a swap stream is floored at a certain strike level. A floor rate schedule is expressed as explicit floor rates and dates and the step dates may be subject to adjustment in accordance with any adjustments specified in calculationPeriodDatesAdjustments. The floor rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal. A floor rate of 5% would be represented as 0.05.
	 */
	List<? extends StrikeSchedule> getFloorRateSchedule();

	/*********************** Build Methods  ***********************/
	FloatingRate build();
	
	FloatingRate.FloatingRateBuilder toBuilder();
	
	static FloatingRate.FloatingRateBuilder builder() {
		return new FloatingRate.FloatingRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FloatingRate> getType() {
		return FloatingRate.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateBuilder extends FloatingRate, Rate.RateBuilder {
		FloatingRateIndexModel.FloatingRateIndexModelBuilder getOrCreateFloatingRateIndexModel();
		FloatingRateIndexModel.FloatingRateIndexModelBuilder getFloatingRateIndexModel();
		Schedule.ScheduleBuilder getOrCreateFloatingRateMultiplierSchedule();
		Schedule.ScheduleBuilder getFloatingRateMultiplierSchedule();
		SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule(int _index);
		List<? extends SpreadSchedule.SpreadScheduleBuilder> getSpreadSchedule();
		StrikeSchedule.StrikeScheduleBuilder getOrCreateCapRateSchedule(int _index);
		List<? extends StrikeSchedule.StrikeScheduleBuilder> getCapRateSchedule();
		StrikeSchedule.StrikeScheduleBuilder getOrCreateFloorRateSchedule(int _index);
		List<? extends StrikeSchedule.StrikeScheduleBuilder> getFloorRateSchedule();
		FloatingRate.FloatingRateBuilder setId(String id);
		FloatingRate.FloatingRateBuilder setFloatingRateIndexModel(FloatingRateIndexModel floatingRateIndexModel);
		FloatingRate.FloatingRateBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule);
		FloatingRate.FloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule0);
		FloatingRate.FloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule1, int _idx);
		FloatingRate.FloatingRateBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule2);
		FloatingRate.FloatingRateBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedule3);
		FloatingRate.FloatingRateBuilder setRateTreatment(RateTreatmentEnum rateTreatment);
		FloatingRate.FloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule0);
		FloatingRate.FloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule1, int _idx);
		FloatingRate.FloatingRateBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule2);
		FloatingRate.FloatingRateBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedule3);
		FloatingRate.FloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule0);
		FloatingRate.FloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule1, int _idx);
		FloatingRate.FloatingRateBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule2);
		FloatingRate.FloatingRateBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedule3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("floatingRateIndexModel"), processor, FloatingRateIndexModel.FloatingRateIndexModelBuilder.class, getFloatingRateIndexModel());
			processRosetta(path.newSubPath("floatingRateMultiplierSchedule"), processor, Schedule.ScheduleBuilder.class, getFloatingRateMultiplierSchedule());
			processRosetta(path.newSubPath("spreadSchedule"), processor, SpreadSchedule.SpreadScheduleBuilder.class, getSpreadSchedule());
			processor.processBasic(path.newSubPath("rateTreatment"), RateTreatmentEnum.class, getRateTreatment(), this);
			processRosetta(path.newSubPath("capRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getCapRateSchedule());
			processRosetta(path.newSubPath("floorRateSchedule"), processor, StrikeSchedule.StrikeScheduleBuilder.class, getFloorRateSchedule());
		}
		

		FloatingRate.FloatingRateBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRate  ***********************/
	class FloatingRateImpl extends Rate.RateImpl implements FloatingRate {
		private final FloatingRateIndexModel floatingRateIndexModel;
		private final Schedule floatingRateMultiplierSchedule;
		private final List<? extends SpreadSchedule> spreadSchedule;
		private final RateTreatmentEnum rateTreatment;
		private final List<? extends StrikeSchedule> capRateSchedule;
		private final List<? extends StrikeSchedule> floorRateSchedule;
		
		protected FloatingRateImpl(FloatingRate.FloatingRateBuilder builder) {
			super(builder);
			this.floatingRateIndexModel = ofNullable(builder.getFloatingRateIndexModel()).map(f->f.build()).orElse(null);
			this.floatingRateMultiplierSchedule = ofNullable(builder.getFloatingRateMultiplierSchedule()).map(f->f.build()).orElse(null);
			this.spreadSchedule = ofNullable(builder.getSpreadSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.rateTreatment = builder.getRateTreatment();
			this.capRateSchedule = ofNullable(builder.getCapRateSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.floorRateSchedule = ofNullable(builder.getFloorRateSchedule()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floatingRateIndexModel")
		public FloatingRateIndexModel getFloatingRateIndexModel() {
			return floatingRateIndexModel;
		}
		
		@Override
		@RosettaAttribute("floatingRateMultiplierSchedule")
		public Schedule getFloatingRateMultiplierSchedule() {
			return floatingRateMultiplierSchedule;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		public List<? extends SpreadSchedule> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		@Override
		@RosettaAttribute("rateTreatment")
		public RateTreatmentEnum getRateTreatment() {
			return rateTreatment;
		}
		
		@Override
		@RosettaAttribute("capRateSchedule")
		public List<? extends StrikeSchedule> getCapRateSchedule() {
			return capRateSchedule;
		}
		
		@Override
		@RosettaAttribute("floorRateSchedule")
		public List<? extends StrikeSchedule> getFloorRateSchedule() {
			return floorRateSchedule;
		}
		
		@Override
		public FloatingRate build() {
			return this;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder toBuilder() {
			FloatingRate.FloatingRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRate.FloatingRateBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFloatingRateIndexModel()).ifPresent(builder::setFloatingRateIndexModel);
			ofNullable(getFloatingRateMultiplierSchedule()).ifPresent(builder::setFloatingRateMultiplierSchedule);
			ofNullable(getSpreadSchedule()).ifPresent(builder::setSpreadSchedule);
			ofNullable(getRateTreatment()).ifPresent(builder::setRateTreatment);
			ofNullable(getCapRateSchedule()).ifPresent(builder::setCapRateSchedule);
			ofNullable(getFloorRateSchedule()).ifPresent(builder::setFloorRateSchedule);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRate _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndexModel, _that.getFloatingRateIndexModel())) return false;
			if (!Objects.equals(floatingRateMultiplierSchedule, _that.getFloatingRateMultiplierSchedule())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			if (!Objects.equals(rateTreatment, _that.getRateTreatment())) return false;
			if (!ListEquals.listEquals(capRateSchedule, _that.getCapRateSchedule())) return false;
			if (!ListEquals.listEquals(floorRateSchedule, _that.getFloorRateSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndexModel != null ? floatingRateIndexModel.hashCode() : 0);
			_result = 31 * _result + (floatingRateMultiplierSchedule != null ? floatingRateMultiplierSchedule.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			_result = 31 * _result + (rateTreatment != null ? rateTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (capRateSchedule != null ? capRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floorRateSchedule != null ? floorRateSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRate {" +
				"floatingRateIndexModel=" + this.floatingRateIndexModel + ", " +
				"floatingRateMultiplierSchedule=" + this.floatingRateMultiplierSchedule + ", " +
				"spreadSchedule=" + this.spreadSchedule + ", " +
				"rateTreatment=" + this.rateTreatment + ", " +
				"capRateSchedule=" + this.capRateSchedule + ", " +
				"floorRateSchedule=" + this.floorRateSchedule +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingRate  ***********************/
	class FloatingRateBuilderImpl extends Rate.RateBuilderImpl  implements FloatingRate.FloatingRateBuilder {
	
		protected FloatingRateIndexModel.FloatingRateIndexModelBuilder floatingRateIndexModel;
		protected Schedule.ScheduleBuilder floatingRateMultiplierSchedule;
		protected List<SpreadSchedule.SpreadScheduleBuilder> spreadSchedule = new ArrayList<>();
		protected RateTreatmentEnum rateTreatment;
		protected List<StrikeSchedule.StrikeScheduleBuilder> capRateSchedule = new ArrayList<>();
		protected List<StrikeSchedule.StrikeScheduleBuilder> floorRateSchedule = new ArrayList<>();
	
		public FloatingRateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("floatingRateIndexModel")
		public FloatingRateIndexModel.FloatingRateIndexModelBuilder getFloatingRateIndexModel() {
			return floatingRateIndexModel;
		}
		
		@Override
		public FloatingRateIndexModel.FloatingRateIndexModelBuilder getOrCreateFloatingRateIndexModel() {
			FloatingRateIndexModel.FloatingRateIndexModelBuilder result;
			if (floatingRateIndexModel!=null) {
				result = floatingRateIndexModel;
			}
			else {
				result = floatingRateIndexModel = FloatingRateIndexModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateMultiplierSchedule")
		public Schedule.ScheduleBuilder getFloatingRateMultiplierSchedule() {
			return floatingRateMultiplierSchedule;
		}
		
		@Override
		public Schedule.ScheduleBuilder getOrCreateFloatingRateMultiplierSchedule() {
			Schedule.ScheduleBuilder result;
			if (floatingRateMultiplierSchedule!=null) {
				result = floatingRateMultiplierSchedule;
			}
			else {
				result = floatingRateMultiplierSchedule = Schedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spreadSchedule")
		public List<? extends SpreadSchedule.SpreadScheduleBuilder> getSpreadSchedule() {
			return spreadSchedule;
		}
		
		public SpreadSchedule.SpreadScheduleBuilder getOrCreateSpreadSchedule(int _index) {
		
			if (spreadSchedule==null) {
				this.spreadSchedule = new ArrayList<>();
			}
			SpreadSchedule.SpreadScheduleBuilder result;
			return getIndex(spreadSchedule, _index, () -> {
						SpreadSchedule.SpreadScheduleBuilder newSpreadSchedule = SpreadSchedule.builder();
						return newSpreadSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("rateTreatment")
		public RateTreatmentEnum getRateTreatment() {
			return rateTreatment;
		}
		
		@Override
		@RosettaAttribute("capRateSchedule")
		public List<? extends StrikeSchedule.StrikeScheduleBuilder> getCapRateSchedule() {
			return capRateSchedule;
		}
		
		public StrikeSchedule.StrikeScheduleBuilder getOrCreateCapRateSchedule(int _index) {
		
			if (capRateSchedule==null) {
				this.capRateSchedule = new ArrayList<>();
			}
			StrikeSchedule.StrikeScheduleBuilder result;
			return getIndex(capRateSchedule, _index, () -> {
						StrikeSchedule.StrikeScheduleBuilder newCapRateSchedule = StrikeSchedule.builder();
						return newCapRateSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("floorRateSchedule")
		public List<? extends StrikeSchedule.StrikeScheduleBuilder> getFloorRateSchedule() {
			return floorRateSchedule;
		}
		
		public StrikeSchedule.StrikeScheduleBuilder getOrCreateFloorRateSchedule(int _index) {
		
			if (floorRateSchedule==null) {
				this.floorRateSchedule = new ArrayList<>();
			}
			StrikeSchedule.StrikeScheduleBuilder result;
			return getIndex(floorRateSchedule, _index, () -> {
						StrikeSchedule.StrikeScheduleBuilder newFloorRateSchedule = StrikeSchedule.builder();
						return newFloorRateSchedule;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public FloatingRate.FloatingRateBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateIndexModel")
		public FloatingRate.FloatingRateBuilder setFloatingRateIndexModel(FloatingRateIndexModel floatingRateIndexModel) {
			this.floatingRateIndexModel = floatingRateIndexModel==null?null:floatingRateIndexModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("floatingRateMultiplierSchedule")
		public FloatingRate.FloatingRateBuilder setFloatingRateMultiplierSchedule(Schedule floatingRateMultiplierSchedule) {
			this.floatingRateMultiplierSchedule = floatingRateMultiplierSchedule==null?null:floatingRateMultiplierSchedule.toBuilder();
			return this;
		}
		@Override
		public FloatingRate.FloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule) {
			if (spreadSchedule!=null) this.spreadSchedule.add(spreadSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder addSpreadSchedule(SpreadSchedule spreadSchedule, int _idx) {
			getIndex(this.spreadSchedule, _idx, () -> spreadSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingRate.FloatingRateBuilder addSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
			if (spreadSchedules != null) {
				for (SpreadSchedule toAdd : spreadSchedules) {
					this.spreadSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("spreadSchedule")
		public FloatingRate.FloatingRateBuilder setSpreadSchedule(List<? extends SpreadSchedule> spreadSchedules) {
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
		public FloatingRate.FloatingRateBuilder setRateTreatment(RateTreatmentEnum rateTreatment) {
			this.rateTreatment = rateTreatment==null?null:rateTreatment;
			return this;
		}
		@Override
		public FloatingRate.FloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule) {
			if (capRateSchedule!=null) this.capRateSchedule.add(capRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder addCapRateSchedule(StrikeSchedule capRateSchedule, int _idx) {
			getIndex(this.capRateSchedule, _idx, () -> capRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingRate.FloatingRateBuilder addCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
			if (capRateSchedules != null) {
				for (StrikeSchedule toAdd : capRateSchedules) {
					this.capRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("capRateSchedule")
		public FloatingRate.FloatingRateBuilder setCapRateSchedule(List<? extends StrikeSchedule> capRateSchedules) {
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
		public FloatingRate.FloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule) {
			if (floorRateSchedule!=null) this.floorRateSchedule.add(floorRateSchedule.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder addFloorRateSchedule(StrikeSchedule floorRateSchedule, int _idx) {
			getIndex(this.floorRateSchedule, _idx, () -> floorRateSchedule.toBuilder());
			return this;
		}
		@Override 
		public FloatingRate.FloatingRateBuilder addFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
			if (floorRateSchedules != null) {
				for (StrikeSchedule toAdd : floorRateSchedules) {
					this.floorRateSchedule.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("floorRateSchedule")
		public FloatingRate.FloatingRateBuilder setFloorRateSchedule(List<? extends StrikeSchedule> floorRateSchedules) {
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
		public FloatingRate build() {
			return new FloatingRate.FloatingRateImpl(this);
		}
		
		@Override
		public FloatingRate.FloatingRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate.FloatingRateBuilder prune() {
			super.prune();
			if (floatingRateIndexModel!=null && !floatingRateIndexModel.prune().hasData()) floatingRateIndexModel = null;
			if (floatingRateMultiplierSchedule!=null && !floatingRateMultiplierSchedule.prune().hasData()) floatingRateMultiplierSchedule = null;
			spreadSchedule = spreadSchedule.stream().filter(b->b!=null).<SpreadSchedule.SpreadScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			capRateSchedule = capRateSchedule.stream().filter(b->b!=null).<StrikeSchedule.StrikeScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			floorRateSchedule = floorRateSchedule.stream().filter(b->b!=null).<StrikeSchedule.StrikeScheduleBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFloatingRateIndexModel()!=null && getFloatingRateIndexModel().hasData()) return true;
			if (getFloatingRateMultiplierSchedule()!=null && getFloatingRateMultiplierSchedule().hasData()) return true;
			if (getSpreadSchedule()!=null && getSpreadSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRateTreatment()!=null) return true;
			if (getCapRateSchedule()!=null && getCapRateSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFloorRateSchedule()!=null && getFloorRateSchedule().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRate.FloatingRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FloatingRate.FloatingRateBuilder o = (FloatingRate.FloatingRateBuilder) other;
			
			merger.mergeRosetta(getFloatingRateIndexModel(), o.getFloatingRateIndexModel(), this::setFloatingRateIndexModel);
			merger.mergeRosetta(getFloatingRateMultiplierSchedule(), o.getFloatingRateMultiplierSchedule(), this::setFloatingRateMultiplierSchedule);
			merger.mergeRosetta(getSpreadSchedule(), o.getSpreadSchedule(), this::getOrCreateSpreadSchedule);
			merger.mergeRosetta(getCapRateSchedule(), o.getCapRateSchedule(), this::getOrCreateCapRateSchedule);
			merger.mergeRosetta(getFloorRateSchedule(), o.getFloorRateSchedule(), this::getOrCreateFloorRateSchedule);
			
			merger.mergeBasic(getRateTreatment(), o.getRateTreatment(), this::setRateTreatment);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingRate _that = getType().cast(o);
		
			if (!Objects.equals(floatingRateIndexModel, _that.getFloatingRateIndexModel())) return false;
			if (!Objects.equals(floatingRateMultiplierSchedule, _that.getFloatingRateMultiplierSchedule())) return false;
			if (!ListEquals.listEquals(spreadSchedule, _that.getSpreadSchedule())) return false;
			if (!Objects.equals(rateTreatment, _that.getRateTreatment())) return false;
			if (!ListEquals.listEquals(capRateSchedule, _that.getCapRateSchedule())) return false;
			if (!ListEquals.listEquals(floorRateSchedule, _that.getFloorRateSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (floatingRateIndexModel != null ? floatingRateIndexModel.hashCode() : 0);
			_result = 31 * _result + (floatingRateMultiplierSchedule != null ? floatingRateMultiplierSchedule.hashCode() : 0);
			_result = 31 * _result + (spreadSchedule != null ? spreadSchedule.hashCode() : 0);
			_result = 31 * _result + (rateTreatment != null ? rateTreatment.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (capRateSchedule != null ? capRateSchedule.hashCode() : 0);
			_result = 31 * _result + (floorRateSchedule != null ? floorRateSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateBuilder {" +
				"floatingRateIndexModel=" + this.floatingRateIndexModel + ", " +
				"floatingRateMultiplierSchedule=" + this.floatingRateMultiplierSchedule + ", " +
				"spreadSchedule=" + this.spreadSchedule + ", " +
				"rateTreatment=" + this.rateTreatment + ", " +
				"capRateSchedule=" + this.capRateSchedule + ", " +
				"floorRateSchedule=" + this.floorRateSchedule +
			'}' + " " + super.toString();
		}
	}
}
