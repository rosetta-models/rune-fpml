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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityEuropeanExerciseSequence;
import fpml.confirmation.CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder;
import fpml.confirmation.CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilderImpl;
import fpml.confirmation.CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceImpl;
import fpml.confirmation.Frequency;
import fpml.confirmation.meta.CommodityEuropeanExerciseSequenceMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityEuropeanExerciseSequence", builder=CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilderImpl.class, version="${project.version}")
public interface CommodityEuropeanExerciseSequence extends RosettaModelObject {

	CommodityEuropeanExerciseSequenceMeta metaData = new CommodityEuropeanExerciseSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period. For an averaging option this is equivalent to the Termination Date.
	 */
	List<? extends AdjustableOrRelativeDate> getExpirationDate();
	/**
	 * The exercise frequency for the strip.
	 */
	Frequency getExerciseFrequency();

	/*********************** Build Methods  ***********************/
	CommodityEuropeanExerciseSequence build();
	
	CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder toBuilder();
	
	static CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder builder() {
		return new CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityEuropeanExerciseSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityEuropeanExerciseSequence> getType() {
		return CommodityEuropeanExerciseSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
		processRosetta(path.newSubPath("exerciseFrequency"), processor, Frequency.class, getExerciseFrequency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityEuropeanExerciseSequenceBuilder extends CommodityEuropeanExerciseSequence, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate(int _index);
		List<? extends AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> getExpirationDate();
		Frequency.FrequencyBuilder getOrCreateExerciseFrequency();
		Frequency.FrequencyBuilder getExerciseFrequency();
		CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder addExpirationDate(AdjustableOrRelativeDate expirationDate0);
		CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder addExpirationDate(AdjustableOrRelativeDate expirationDate1, int _idx);
		CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder addExpirationDate(List<? extends AdjustableOrRelativeDate> expirationDate2);
		CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder setExpirationDate(List<? extends AdjustableOrRelativeDate> expirationDate3);
		CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder setExerciseFrequency(Frequency exerciseFrequency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
			processRosetta(path.newSubPath("exerciseFrequency"), processor, Frequency.FrequencyBuilder.class, getExerciseFrequency());
		}
		

		CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityEuropeanExerciseSequence  ***********************/
	class CommodityEuropeanExerciseSequenceImpl implements CommodityEuropeanExerciseSequence {
		private final List<? extends AdjustableOrRelativeDate> expirationDate;
		private final Frequency exerciseFrequency;
		
		protected CommodityEuropeanExerciseSequenceImpl(CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder builder) {
			this.expirationDate = ofNullable(builder.getExpirationDate()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.exerciseFrequency = ofNullable(builder.getExerciseFrequency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public List<? extends AdjustableOrRelativeDate> getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		@RosettaAttribute("exerciseFrequency")
		public Frequency getExerciseFrequency() {
			return exerciseFrequency;
		}
		
		@Override
		public CommodityEuropeanExerciseSequence build() {
			return this;
		}
		
		@Override
		public CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder toBuilder() {
			CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder builder) {
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
			ofNullable(getExerciseFrequency()).ifPresent(builder::setExerciseFrequency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityEuropeanExerciseSequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(exerciseFrequency, _that.getExerciseFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (exerciseFrequency != null ? exerciseFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityEuropeanExerciseSequence {" +
				"expirationDate=" + this.expirationDate + ", " +
				"exerciseFrequency=" + this.exerciseFrequency +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityEuropeanExerciseSequence  ***********************/
	class CommodityEuropeanExerciseSequenceBuilderImpl implements CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder {
	
		protected List<AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> expirationDate = new ArrayList<>();
		protected Frequency.FrequencyBuilder exerciseFrequency;
	
		public CommodityEuropeanExerciseSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expirationDate")
		public List<? extends AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate(int _index) {
		
			if (expirationDate==null) {
				this.expirationDate = new ArrayList<>();
			}
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			return getIndex(expirationDate, _index, () -> {
						AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder newExpirationDate = AdjustableOrRelativeDate.builder();
						return newExpirationDate;
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
		@RosettaAttribute("expirationDate")
		public CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder addExpirationDate(AdjustableOrRelativeDate expirationDate) {
			if (expirationDate!=null) this.expirationDate.add(expirationDate.toBuilder());
			return this;
		}
		
		@Override
		public CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder addExpirationDate(AdjustableOrRelativeDate expirationDate, int _idx) {
			getIndex(this.expirationDate, _idx, () -> expirationDate.toBuilder());
			return this;
		}
		@Override 
		public CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder addExpirationDate(List<? extends AdjustableOrRelativeDate> expirationDates) {
			if (expirationDates != null) {
				for (AdjustableOrRelativeDate toAdd : expirationDates) {
					this.expirationDate.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder setExpirationDate(List<? extends AdjustableOrRelativeDate> expirationDates) {
			if (expirationDates == null)  {
				this.expirationDate = new ArrayList<>();
			}
			else {
				this.expirationDate = expirationDates.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("exerciseFrequency")
		public CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder setExerciseFrequency(Frequency exerciseFrequency) {
			this.exerciseFrequency = exerciseFrequency==null?null:exerciseFrequency.toBuilder();
			return this;
		}
		
		@Override
		public CommodityEuropeanExerciseSequence build() {
			return new CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceImpl(this);
		}
		
		@Override
		public CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder prune() {
			expirationDate = expirationDate.stream().filter(b->b!=null).<AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (exerciseFrequency!=null && !exerciseFrequency.prune().hasData()) exerciseFrequency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExpirationDate()!=null && getExpirationDate().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getExerciseFrequency()!=null && getExerciseFrequency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder o = (CommodityEuropeanExerciseSequence.CommodityEuropeanExerciseSequenceBuilder) other;
			
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::getOrCreateExpirationDate);
			merger.mergeRosetta(getExerciseFrequency(), o.getExerciseFrequency(), this::setExerciseFrequency);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityEuropeanExerciseSequence _that = getType().cast(o);
		
			if (!ListEquals.listEquals(expirationDate, _that.getExpirationDate())) return false;
			if (!Objects.equals(exerciseFrequency, _that.getExerciseFrequency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			_result = 31 * _result + (exerciseFrequency != null ? exerciseFrequency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityEuropeanExerciseSequenceBuilder {" +
				"expirationDate=" + this.expirationDate + ", " +
				"exerciseFrequency=" + this.exerciseFrequency +
			'}';
		}
	}
}
