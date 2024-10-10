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
import fpml.confirmation.FxAccrualConditionLevelModelSequence;
import fpml.confirmation.FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder;
import fpml.confirmation.FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilderImpl;
import fpml.confirmation.FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceImpl;
import fpml.confirmation.FxLevel;
import fpml.confirmation.QuoteBasisEnum;
import fpml.confirmation.meta.FxAccrualConditionLevelModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxAccrualConditionLevelModelSequence", builder=FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilderImpl.class, version="${project.version}")
public interface FxAccrualConditionLevelModelSequence extends RosettaModelObject {

	FxAccrualConditionLevelModelSequenceMeta metaData = new FxAccrualConditionLevelModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Level expressed as a level.
	 */
	FxLevel getLevel();
	/**
	 * The Quoted Currency Pair that is used accross the product.
	 */
	QuoteBasisEnum getQuoteBasis();

	/*********************** Build Methods  ***********************/
	FxAccrualConditionLevelModelSequence build();
	
	FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder toBuilder();
	
	static FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder builder() {
		return new FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualConditionLevelModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualConditionLevelModelSequence> getType() {
		return FxAccrualConditionLevelModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("level"), processor, FxLevel.class, getLevel());
		processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualConditionLevelModelSequenceBuilder extends FxAccrualConditionLevelModelSequence, RosettaModelObjectBuilder {
		FxLevel.FxLevelBuilder getOrCreateLevel();
		FxLevel.FxLevelBuilder getLevel();
		FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder setLevel(FxLevel level);
		FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder setQuoteBasis(QuoteBasisEnum quoteBasis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("level"), processor, FxLevel.FxLevelBuilder.class, getLevel());
			processor.processBasic(path.newSubPath("quoteBasis"), QuoteBasisEnum.class, getQuoteBasis(), this);
		}
		

		FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualConditionLevelModelSequence  ***********************/
	class FxAccrualConditionLevelModelSequenceImpl implements FxAccrualConditionLevelModelSequence {
		private final FxLevel level;
		private final QuoteBasisEnum quoteBasis;
		
		protected FxAccrualConditionLevelModelSequenceImpl(FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder builder) {
			this.level = ofNullable(builder.getLevel()).map(f->f.build()).orElse(null);
			this.quoteBasis = builder.getQuoteBasis();
		}
		
		@Override
		@RosettaAttribute("level")
		public FxLevel getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("quoteBasis")
		public QuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@Override
		public FxAccrualConditionLevelModelSequence build() {
			return this;
		}
		
		@Override
		public FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder toBuilder() {
			FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder builder) {
			ofNullable(getLevel()).ifPresent(builder::setLevel);
			ofNullable(getQuoteBasis()).ifPresent(builder::setQuoteBasis);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualConditionLevelModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualConditionLevelModelSequence {" +
				"level=" + this.level + ", " +
				"quoteBasis=" + this.quoteBasis +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualConditionLevelModelSequence  ***********************/
	class FxAccrualConditionLevelModelSequenceBuilderImpl implements FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder {
	
		protected FxLevel.FxLevelBuilder level;
		protected QuoteBasisEnum quoteBasis;
	
		public FxAccrualConditionLevelModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("level")
		public FxLevel.FxLevelBuilder getLevel() {
			return level;
		}
		
		@Override
		public FxLevel.FxLevelBuilder getOrCreateLevel() {
			FxLevel.FxLevelBuilder result;
			if (level!=null) {
				result = level;
			}
			else {
				result = level = FxLevel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quoteBasis")
		public QuoteBasisEnum getQuoteBasis() {
			return quoteBasis;
		}
		
		@Override
		@RosettaAttribute("level")
		public FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder setLevel(FxLevel level) {
			this.level = level==null?null:level.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("quoteBasis")
		public FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder setQuoteBasis(QuoteBasisEnum quoteBasis) {
			this.quoteBasis = quoteBasis==null?null:quoteBasis;
			return this;
		}
		
		@Override
		public FxAccrualConditionLevelModelSequence build() {
			return new FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceImpl(this);
		}
		
		@Override
		public FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder prune() {
			if (level!=null && !level.prune().hasData()) level = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLevel()!=null && getLevel().hasData()) return true;
			if (getQuoteBasis()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder o = (FxAccrualConditionLevelModelSequence.FxAccrualConditionLevelModelSequenceBuilder) other;
			
			merger.mergeRosetta(getLevel(), o.getLevel(), this::setLevel);
			
			merger.mergeBasic(getQuoteBasis(), o.getQuoteBasis(), this::setQuoteBasis);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualConditionLevelModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(quoteBasis, _that.getQuoteBasis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (quoteBasis != null ? quoteBasis.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualConditionLevelModelSequenceBuilder {" +
				"level=" + this.level + ", " +
				"quoteBasis=" + this.quoteBasis +
			'}';
		}
	}
}
