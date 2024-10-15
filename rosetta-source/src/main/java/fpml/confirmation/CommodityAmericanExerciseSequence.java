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
import fpml.confirmation.CommodityAmericanExerciseSequence;
import fpml.confirmation.CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder;
import fpml.confirmation.CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilderImpl;
import fpml.confirmation.CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceImpl;
import fpml.confirmation.CommodityExercisePeriods;
import fpml.confirmation.Frequency;
import fpml.confirmation.meta.CommodityAmericanExerciseSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityAmericanExerciseSequence", builder=CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilderImpl.class, version="${project.version}")
public interface CommodityAmericanExerciseSequence extends RosettaModelObject {

	CommodityAmericanExerciseSequenceMeta metaData = new CommodityAmericanExerciseSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Describes the American exercise periods.
	 */
	List<? extends CommodityExercisePeriods> getExercisePeriod();
	/**
	 * The exercise frequency for the strip.
	 */
	Frequency getExerciseFrequency();

	/*********************** Build Methods  ***********************/
	CommodityAmericanExerciseSequence build();
	
	CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder toBuilder();
	
	static CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder builder() {
		return new CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityAmericanExerciseSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityAmericanExerciseSequence> getType() {
		return CommodityAmericanExerciseSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("exercisePeriod"), processor, CommodityExercisePeriods.class, getExercisePeriod());
		processRosetta(path.newSubPath("exerciseFrequency"), processor, Frequency.class, getExerciseFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityAmericanExerciseSequenceBuilder extends CommodityAmericanExerciseSequence, RosettaModelObjectBuilder {
		CommodityExercisePeriods.CommodityExercisePeriodsBuilder getOrCreateExercisePeriod(int _index);
		List<? extends CommodityExercisePeriods.CommodityExercisePeriodsBuilder> getExercisePeriod();
		Frequency.FrequencyBuilder getOrCreateExerciseFrequency();
		Frequency.FrequencyBuilder getExerciseFrequency();
		CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder addExercisePeriod(CommodityExercisePeriods exercisePeriod0);
		CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder addExercisePeriod(CommodityExercisePeriods exercisePeriod1, int _idx);
		CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder addExercisePeriod(List<? extends CommodityExercisePeriods> exercisePeriod2);
		CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder setExercisePeriod(List<? extends CommodityExercisePeriods> exercisePeriod3);
		CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder setExerciseFrequency(Frequency exerciseFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("exercisePeriod"), processor, CommodityExercisePeriods.CommodityExercisePeriodsBuilder.class, getExercisePeriod());
			processRosetta(path.newSubPath("exerciseFrequency"), processor, Frequency.FrequencyBuilder.class, getExerciseFrequency());
		}
		

		CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityAmericanExerciseSequence  ***********************/
	class CommodityAmericanExerciseSequenceImpl implements CommodityAmericanExerciseSequence {
		private final List<? extends CommodityExercisePeriods> exercisePeriod;
		private final Frequency exerciseFrequency;
		
		protected CommodityAmericanExerciseSequenceImpl(CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder builder) {
			this.exercisePeriod = ofNullable(builder.getExercisePeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.exerciseFrequency = ofNullable(builder.getExerciseFrequency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exercisePeriod")
		public List<? extends CommodityExercisePeriods> getExercisePeriod() {
			return exercisePeriod;
		}
		
		@Override
		@RosettaAttribute("exerciseFrequency")
		public Frequency getExerciseFrequency() {
			return exerciseFrequency;
		}
		
		@Override
		public CommodityAmericanExerciseSequence build() {
			return this;
		}
		
		@Override
		public CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder toBuilder() {
			CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder builder) {
			ofNullable(getExercisePeriod()).ifPresent(builder::setExercisePeriod);
			ofNullable(getExerciseFrequency()).ifPresent(builder::setExerciseFrequency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityAmericanExerciseSequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(exercisePeriod, _that.getExercisePeriod())) return false;
			if (!Objects.equals(exerciseFrequency, _that.getExerciseFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exercisePeriod != null ? exercisePeriod.hashCode() : 0);
			_result = 31 * _result + (exerciseFrequency != null ? exerciseFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityAmericanExerciseSequence {" +
				"exercisePeriod=" + this.exercisePeriod + ", " +
				"exerciseFrequency=" + this.exerciseFrequency +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityAmericanExerciseSequence  ***********************/
	class CommodityAmericanExerciseSequenceBuilderImpl implements CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder {
	
		protected List<CommodityExercisePeriods.CommodityExercisePeriodsBuilder> exercisePeriod = new ArrayList<>();
		protected Frequency.FrequencyBuilder exerciseFrequency;
	
		public CommodityAmericanExerciseSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("exercisePeriod")
		public List<? extends CommodityExercisePeriods.CommodityExercisePeriodsBuilder> getExercisePeriod() {
			return exercisePeriod;
		}
		
		public CommodityExercisePeriods.CommodityExercisePeriodsBuilder getOrCreateExercisePeriod(int _index) {
		
			if (exercisePeriod==null) {
				this.exercisePeriod = new ArrayList<>();
			}
			CommodityExercisePeriods.CommodityExercisePeriodsBuilder result;
			return getIndex(exercisePeriod, _index, () -> {
						CommodityExercisePeriods.CommodityExercisePeriodsBuilder newExercisePeriod = CommodityExercisePeriods.builder();
						return newExercisePeriod;
					});
		}
		
		@Override
		@RosettaAttribute("exerciseFrequency")
		public Frequency.FrequencyBuilder getExerciseFrequency() {
			return exerciseFrequency;
		}
		
		@Override
		public Frequency.FrequencyBuilder getOrCreateExerciseFrequency() {
			Frequency.FrequencyBuilder result;
			if (exerciseFrequency!=null) {
				result = exerciseFrequency;
			}
			else {
				result = exerciseFrequency = Frequency.builder();
			}
			
			return result;
		}
		
		@Override
		public CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder addExercisePeriod(CommodityExercisePeriods exercisePeriod) {
			if (exercisePeriod!=null) this.exercisePeriod.add(exercisePeriod.toBuilder());
			return this;
		}
		
		@Override
		public CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder addExercisePeriod(CommodityExercisePeriods exercisePeriod, int _idx) {
			getIndex(this.exercisePeriod, _idx, () -> exercisePeriod.toBuilder());
			return this;
		}
		@Override 
		public CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder addExercisePeriod(List<? extends CommodityExercisePeriods> exercisePeriods) {
			if (exercisePeriods != null) {
				for (CommodityExercisePeriods toAdd : exercisePeriods) {
					this.exercisePeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("exercisePeriod")
		public CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder setExercisePeriod(List<? extends CommodityExercisePeriods> exercisePeriods) {
			if (exercisePeriods == null)  {
				this.exercisePeriod = new ArrayList<>();
			}
			else {
				this.exercisePeriod = exercisePeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("exerciseFrequency")
		public CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder setExerciseFrequency(Frequency exerciseFrequency) {
			this.exerciseFrequency = exerciseFrequency==null?null:exerciseFrequency.toBuilder();
			return this;
		}
		
		@Override
		public CommodityAmericanExerciseSequence build() {
			return new CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceImpl(this);
		}
		
		@Override
		public CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder prune() {
			exercisePeriod = exercisePeriod.stream().filter(b->b!=null).<CommodityExercisePeriods.CommodityExercisePeriodsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (exerciseFrequency!=null && !exerciseFrequency.prune().hasData()) exerciseFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExercisePeriod()!=null && getExercisePeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExerciseFrequency()!=null && getExerciseFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder o = (CommodityAmericanExerciseSequence.CommodityAmericanExerciseSequenceBuilder) other;
			
			merger.mergeRosetta(getExercisePeriod(), o.getExercisePeriod(), this::getOrCreateExercisePeriod);
			merger.mergeRosetta(getExerciseFrequency(), o.getExerciseFrequency(), this::setExerciseFrequency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityAmericanExerciseSequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(exercisePeriod, _that.getExercisePeriod())) return false;
			if (!Objects.equals(exerciseFrequency, _that.getExerciseFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exercisePeriod != null ? exercisePeriod.hashCode() : 0);
			_result = 31 * _result + (exerciseFrequency != null ? exerciseFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityAmericanExerciseSequenceBuilder {" +
				"exercisePeriod=" + this.exercisePeriod + ", " +
				"exerciseFrequency=" + this.exerciseFrequency +
			'}';
		}
	}
}
