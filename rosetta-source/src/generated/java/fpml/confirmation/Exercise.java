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
import fpml.confirmation.Exercise;
import fpml.confirmation.Exercise.ExerciseBuilder;
import fpml.confirmation.Exercise.ExerciseBuilderImpl;
import fpml.confirmation.Exercise.ExerciseImpl;
import fpml.confirmation.meta.ExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An placeholder for the actual option exercise definitions. The abstract base class for all types which define way in which options may be exercised.
 * @version ${project.version}
 */
@RosettaDataType(value="Exercise", builder=Exercise.ExerciseBuilderImpl.class, version="${project.version}")
public interface Exercise extends RosettaModelObject {

	ExerciseMeta metaData = new ExerciseMeta();

	/*********************** Getter Methods  ***********************/
	String getId();

	/*********************** Build Methods  ***********************/
	Exercise build();
	
	Exercise.ExerciseBuilder toBuilder();
	
	static Exercise.ExerciseBuilder builder() {
		return new Exercise.ExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Exercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Exercise> getType() {
		return Exercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExerciseBuilder extends Exercise, RosettaModelObjectBuilder {
		Exercise.ExerciseBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Exercise.ExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of Exercise  ***********************/
	class ExerciseImpl implements Exercise {
		private final String id;
		
		protected ExerciseImpl(Exercise.ExerciseBuilder builder) {
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Exercise build() {
			return this;
		}
		
		@Override
		public Exercise.ExerciseBuilder toBuilder() {
			Exercise.ExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Exercise.ExerciseBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Exercise _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Exercise {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Exercise  ***********************/
	class ExerciseBuilderImpl implements Exercise.ExerciseBuilder {
	
		protected String id;
	
		public ExerciseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("id")
		public Exercise.ExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Exercise build() {
			return new Exercise.ExerciseImpl(this);
		}
		
		@Override
		public Exercise.ExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Exercise.ExerciseBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Exercise.ExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Exercise.ExerciseBuilder o = (Exercise.ExerciseBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Exercise _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseBuilder {" +
				"id=" + this.id +
			'}';
		}
	}
}
