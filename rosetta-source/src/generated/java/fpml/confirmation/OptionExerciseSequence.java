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
import fpml.confirmation.OptionExerciseSequence;
import fpml.confirmation.OptionExerciseSequence.OptionExerciseSequenceBuilder;
import fpml.confirmation.OptionExerciseSequence.OptionExerciseSequenceBuilderImpl;
import fpml.confirmation.OptionExerciseSequence.OptionExerciseSequenceImpl;
import fpml.confirmation.meta.OptionExerciseSequenceMeta;
import java.time.LocalTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionExerciseSequence", builder=OptionExerciseSequence.OptionExerciseSequenceBuilderImpl.class, version="${project.version}")
public interface OptionExerciseSequence extends RosettaModelObject {

	OptionExerciseSequenceMeta metaData = new OptionExerciseSequenceMeta();

	/*********************** Getter Methods  ***********************/
	Date getExerciseDate();
	LocalTime getExerciseTime();

	/*********************** Build Methods  ***********************/
	OptionExerciseSequence build();
	
	OptionExerciseSequence.OptionExerciseSequenceBuilder toBuilder();
	
	static OptionExerciseSequence.OptionExerciseSequenceBuilder builder() {
		return new OptionExerciseSequence.OptionExerciseSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionExerciseSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionExerciseSequence> getType() {
		return OptionExerciseSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("exerciseDate"), Date.class, getExerciseDate(), this);
		processor.processBasic(path.newSubPath("exerciseTime"), LocalTime.class, getExerciseTime(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionExerciseSequenceBuilder extends OptionExerciseSequence, RosettaModelObjectBuilder {
		OptionExerciseSequence.OptionExerciseSequenceBuilder setExerciseDate(Date exerciseDate);
		OptionExerciseSequence.OptionExerciseSequenceBuilder setExerciseTime(LocalTime exerciseTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("exerciseDate"), Date.class, getExerciseDate(), this);
			processor.processBasic(path.newSubPath("exerciseTime"), LocalTime.class, getExerciseTime(), this);
		}
		

		OptionExerciseSequence.OptionExerciseSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of OptionExerciseSequence  ***********************/
	class OptionExerciseSequenceImpl implements OptionExerciseSequence {
		private final Date exerciseDate;
		private final LocalTime exerciseTime;
		
		protected OptionExerciseSequenceImpl(OptionExerciseSequence.OptionExerciseSequenceBuilder builder) {
			this.exerciseDate = builder.getExerciseDate();
			this.exerciseTime = builder.getExerciseTime();
		}
		
		@Override
		@RosettaAttribute("exerciseDate")
		public Date getExerciseDate() {
			return exerciseDate;
		}
		
		@Override
		@RosettaAttribute("exerciseTime")
		public LocalTime getExerciseTime() {
			return exerciseTime;
		}
		
		@Override
		public OptionExerciseSequence build() {
			return this;
		}
		
		@Override
		public OptionExerciseSequence.OptionExerciseSequenceBuilder toBuilder() {
			OptionExerciseSequence.OptionExerciseSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionExerciseSequence.OptionExerciseSequenceBuilder builder) {
			ofNullable(getExerciseDate()).ifPresent(builder::setExerciseDate);
			ofNullable(getExerciseTime()).ifPresent(builder::setExerciseTime);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseSequence _that = getType().cast(o);
		
			if (!Objects.equals(exerciseDate, _that.getExerciseDate())) return false;
			if (!Objects.equals(exerciseTime, _that.getExerciseTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseDate != null ? exerciseDate.hashCode() : 0);
			_result = 31 * _result + (exerciseTime != null ? exerciseTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseSequence {" +
				"exerciseDate=" + this.exerciseDate + ", " +
				"exerciseTime=" + this.exerciseTime +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionExerciseSequence  ***********************/
	class OptionExerciseSequenceBuilderImpl implements OptionExerciseSequence.OptionExerciseSequenceBuilder {
	
		protected Date exerciseDate;
		protected LocalTime exerciseTime;
	
		public OptionExerciseSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("exerciseDate")
		public Date getExerciseDate() {
			return exerciseDate;
		}
		
		@Override
		@RosettaAttribute("exerciseTime")
		public LocalTime getExerciseTime() {
			return exerciseTime;
		}
		
		@Override
		@RosettaAttribute("exerciseDate")
		public OptionExerciseSequence.OptionExerciseSequenceBuilder setExerciseDate(Date exerciseDate) {
			this.exerciseDate = exerciseDate==null?null:exerciseDate;
			return this;
		}
		@Override
		@RosettaAttribute("exerciseTime")
		public OptionExerciseSequence.OptionExerciseSequenceBuilder setExerciseTime(LocalTime exerciseTime) {
			this.exerciseTime = exerciseTime==null?null:exerciseTime;
			return this;
		}
		
		@Override
		public OptionExerciseSequence build() {
			return new OptionExerciseSequence.OptionExerciseSequenceImpl(this);
		}
		
		@Override
		public OptionExerciseSequence.OptionExerciseSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseSequence.OptionExerciseSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExerciseDate()!=null) return true;
			if (getExerciseTime()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionExerciseSequence.OptionExerciseSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionExerciseSequence.OptionExerciseSequenceBuilder o = (OptionExerciseSequence.OptionExerciseSequenceBuilder) other;
			
			
			merger.mergeBasic(getExerciseDate(), o.getExerciseDate(), this::setExerciseDate);
			merger.mergeBasic(getExerciseTime(), o.getExerciseTime(), this::setExerciseTime);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionExerciseSequence _that = getType().cast(o);
		
			if (!Objects.equals(exerciseDate, _that.getExerciseDate())) return false;
			if (!Objects.equals(exerciseTime, _that.getExerciseTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseDate != null ? exerciseDate.hashCode() : 0);
			_result = 31 * _result + (exerciseTime != null ? exerciseTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionExerciseSequenceBuilder {" +
				"exerciseDate=" + this.exerciseDate + ", " +
				"exerciseTime=" + this.exerciseTime +
			'}';
		}
	}
}
