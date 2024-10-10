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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.CutName;
import fpml.confirmation.FxAmericanExercise;
import fpml.confirmation.FxAmericanExercise.FxAmericanExerciseBuilder;
import fpml.confirmation.FxAmericanExercise.FxAmericanExerciseBuilderImpl;
import fpml.confirmation.FxAmericanExercise.FxAmericanExerciseImpl;
import fpml.confirmation.FxDigitalAmericanExercise;
import fpml.confirmation.FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder;
import fpml.confirmation.FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilderImpl;
import fpml.confirmation.FxDigitalAmericanExercise.FxDigitalAmericanExerciseImpl;
import fpml.confirmation.FxMultipleExercise;
import fpml.confirmation.meta.FxAmericanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes the characteristics for american exercise of FX products.
 * @version ${project.version}
 */
@RosettaDataType(value="FxAmericanExercise", builder=FxAmericanExercise.FxAmericanExerciseBuilderImpl.class, version="${project.version}")
public interface FxAmericanExercise extends FxDigitalAmericanExercise {

	FxAmericanExerciseMeta metaData = new FxAmericanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Characteristics for multiple exercise.
	 */
	FxMultipleExercise getMultipleExercise();

	/*********************** Build Methods  ***********************/
	FxAmericanExercise build();
	
	FxAmericanExercise.FxAmericanExerciseBuilder toBuilder();
	
	static FxAmericanExercise.FxAmericanExerciseBuilder builder() {
		return new FxAmericanExercise.FxAmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAmericanExercise> getType() {
		return FxAmericanExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.class, getCommencementDate());
		processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
		processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.class, getExpiryTime());
		processRosetta(path.newSubPath("cutName"), processor, CutName.class, getCutName());
		processor.processBasic(path.newSubPath("latestValueDate"), Date.class, getLatestValueDate(), this);
		processRosetta(path.newSubPath("multipleExercise"), processor, FxMultipleExercise.class, getMultipleExercise());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAmericanExerciseBuilder extends FxAmericanExercise, FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilder {
		FxMultipleExercise.FxMultipleExerciseBuilder getOrCreateMultipleExercise();
		FxMultipleExercise.FxMultipleExerciseBuilder getMultipleExercise();
		FxAmericanExercise.FxAmericanExerciseBuilder setId(String id);
		FxAmericanExercise.FxAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate);
		FxAmericanExercise.FxAmericanExerciseBuilder setExpiryDate(Date expiryDate);
		FxAmericanExercise.FxAmericanExerciseBuilder setExpiryTime(BusinessCenterTime expiryTime);
		FxAmericanExercise.FxAmericanExerciseBuilder setCutName(CutName cutName);
		FxAmericanExercise.FxAmericanExerciseBuilder setLatestValueDate(Date latestValueDate);
		FxAmericanExercise.FxAmericanExerciseBuilder setMultipleExercise(FxMultipleExercise multipleExercise);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCommencementDate());
			processor.processBasic(path.newSubPath("expiryDate"), Date.class, getExpiryDate(), this);
			processRosetta(path.newSubPath("expiryTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExpiryTime());
			processRosetta(path.newSubPath("cutName"), processor, CutName.CutNameBuilder.class, getCutName());
			processor.processBasic(path.newSubPath("latestValueDate"), Date.class, getLatestValueDate(), this);
			processRosetta(path.newSubPath("multipleExercise"), processor, FxMultipleExercise.FxMultipleExerciseBuilder.class, getMultipleExercise());
		}
		

		FxAmericanExercise.FxAmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of FxAmericanExercise  ***********************/
	class FxAmericanExerciseImpl extends FxDigitalAmericanExercise.FxDigitalAmericanExerciseImpl implements FxAmericanExercise {
		private final FxMultipleExercise multipleExercise;
		
		protected FxAmericanExerciseImpl(FxAmericanExercise.FxAmericanExerciseBuilder builder) {
			super(builder);
			this.multipleExercise = ofNullable(builder.getMultipleExercise()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("multipleExercise")
		public FxMultipleExercise getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public FxAmericanExercise build() {
			return this;
		}
		
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder toBuilder() {
			FxAmericanExercise.FxAmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAmericanExercise.FxAmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMultipleExercise()).ifPresent(builder::setMultipleExercise);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAmericanExercise {" +
				"multipleExercise=" + this.multipleExercise +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxAmericanExercise  ***********************/
	class FxAmericanExerciseBuilderImpl extends FxDigitalAmericanExercise.FxDigitalAmericanExerciseBuilderImpl  implements FxAmericanExercise.FxAmericanExerciseBuilder {
	
		protected FxMultipleExercise.FxMultipleExerciseBuilder multipleExercise;
	
		public FxAmericanExerciseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("multipleExercise")
		public FxMultipleExercise.FxMultipleExerciseBuilder getMultipleExercise() {
			return multipleExercise;
		}
		
		@Override
		public FxMultipleExercise.FxMultipleExerciseBuilder getOrCreateMultipleExercise() {
			FxMultipleExercise.FxMultipleExerciseBuilder result;
			if (multipleExercise!=null) {
				result = multipleExercise;
			}
			else {
				result = multipleExercise = FxMultipleExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxAmericanExercise.FxAmericanExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("commencementDate")
		public FxAmericanExercise.FxAmericanExerciseBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate) {
			this.commencementDate = commencementDate==null?null:commencementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expiryDate")
		public FxAmericanExercise.FxAmericanExerciseBuilder setExpiryDate(Date expiryDate) {
			this.expiryDate = expiryDate==null?null:expiryDate;
			return this;
		}
		@Override
		@RosettaAttribute("expiryTime")
		public FxAmericanExercise.FxAmericanExerciseBuilder setExpiryTime(BusinessCenterTime expiryTime) {
			this.expiryTime = expiryTime==null?null:expiryTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("cutName")
		public FxAmericanExercise.FxAmericanExerciseBuilder setCutName(CutName cutName) {
			this.cutName = cutName==null?null:cutName.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestValueDate")
		public FxAmericanExercise.FxAmericanExerciseBuilder setLatestValueDate(Date latestValueDate) {
			this.latestValueDate = latestValueDate==null?null:latestValueDate;
			return this;
		}
		@Override
		@RosettaAttribute("multipleExercise")
		public FxAmericanExercise.FxAmericanExerciseBuilder setMultipleExercise(FxMultipleExercise multipleExercise) {
			this.multipleExercise = multipleExercise==null?null:multipleExercise.toBuilder();
			return this;
		}
		
		@Override
		public FxAmericanExercise build() {
			return new FxAmericanExercise.FxAmericanExerciseImpl(this);
		}
		
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder prune() {
			super.prune();
			if (multipleExercise!=null && !multipleExercise.prune().hasData()) multipleExercise = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMultipleExercise()!=null && getMultipleExercise().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAmericanExercise.FxAmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxAmericanExercise.FxAmericanExerciseBuilder o = (FxAmericanExercise.FxAmericanExerciseBuilder) other;
			
			merger.mergeRosetta(getMultipleExercise(), o.getMultipleExercise(), this::setMultipleExercise);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(multipleExercise, _that.getMultipleExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (multipleExercise != null ? multipleExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAmericanExerciseBuilder {" +
				"multipleExercise=" + this.multipleExercise +
			'}' + " " + super.toString();
		}
	}
}
