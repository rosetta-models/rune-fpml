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
import fpml.confirmation.Trigger;
import fpml.confirmation.Trigger.TriggerBuilder;
import fpml.confirmation.Trigger.TriggerBuilderImpl;
import fpml.confirmation.Trigger.TriggerImpl;
import fpml.confirmation.TriggerChoice;
import fpml.confirmation.TriggerTimeTypeEnum;
import fpml.confirmation.TriggerTypeEnum;
import fpml.confirmation.meta.TriggerMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Trigger point at which feature is effective.
 * @version ${project.version}
 */
@RosettaDataType(value="Trigger", builder=Trigger.TriggerBuilderImpl.class, version="${project.version}")
public interface Trigger extends RosettaModelObject {

	TriggerMeta metaData = new TriggerMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The trigger level.
	 */
	BigDecimal getLevel();
	/**
	 * The trigger level percentage.
	 */
	BigDecimal getLevelPercentage();
	TriggerChoice getTriggerChoice();
	/**
	 * The Triggering condition.
	 */
	TriggerTypeEnum getTriggerType();
	/**
	 * The valuation time type of knock condition.
	 */
	TriggerTimeTypeEnum getTriggerTimeType();

	/*********************** Build Methods  ***********************/
	Trigger build();
	
	Trigger.TriggerBuilder toBuilder();
	
	static Trigger.TriggerBuilder builder() {
		return new Trigger.TriggerBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Trigger> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Trigger> getType() {
		return Trigger.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("level"), BigDecimal.class, getLevel(), this);
		processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
		processRosetta(path.newSubPath("triggerChoice"), processor, TriggerChoice.class, getTriggerChoice());
		processor.processBasic(path.newSubPath("triggerType"), TriggerTypeEnum.class, getTriggerType(), this);
		processor.processBasic(path.newSubPath("triggerTimeType"), TriggerTimeTypeEnum.class, getTriggerTimeType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TriggerBuilder extends Trigger, RosettaModelObjectBuilder {
		TriggerChoice.TriggerChoiceBuilder getOrCreateTriggerChoice();
		TriggerChoice.TriggerChoiceBuilder getTriggerChoice();
		Trigger.TriggerBuilder setLevel(BigDecimal level);
		Trigger.TriggerBuilder setLevelPercentage(BigDecimal levelPercentage);
		Trigger.TriggerBuilder setTriggerChoice(TriggerChoice triggerChoice);
		Trigger.TriggerBuilder setTriggerType(TriggerTypeEnum triggerType);
		Trigger.TriggerBuilder setTriggerTimeType(TriggerTimeTypeEnum triggerTimeType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("level"), BigDecimal.class, getLevel(), this);
			processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
			processRosetta(path.newSubPath("triggerChoice"), processor, TriggerChoice.TriggerChoiceBuilder.class, getTriggerChoice());
			processor.processBasic(path.newSubPath("triggerType"), TriggerTypeEnum.class, getTriggerType(), this);
			processor.processBasic(path.newSubPath("triggerTimeType"), TriggerTimeTypeEnum.class, getTriggerTimeType(), this);
		}
		

		Trigger.TriggerBuilder prune();
	}

	/*********************** Immutable Implementation of Trigger  ***********************/
	class TriggerImpl implements Trigger {
		private final BigDecimal level;
		private final BigDecimal levelPercentage;
		private final TriggerChoice triggerChoice;
		private final TriggerTypeEnum triggerType;
		private final TriggerTimeTypeEnum triggerTimeType;
		
		protected TriggerImpl(Trigger.TriggerBuilder builder) {
			this.level = builder.getLevel();
			this.levelPercentage = builder.getLevelPercentage();
			this.triggerChoice = ofNullable(builder.getTriggerChoice()).map(f->f.build()).orElse(null);
			this.triggerType = builder.getTriggerType();
			this.triggerTimeType = builder.getTriggerTimeType();
		}
		
		@Override
		@RosettaAttribute("level")
		public BigDecimal getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("levelPercentage")
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		@RosettaAttribute("triggerChoice")
		public TriggerChoice getTriggerChoice() {
			return triggerChoice;
		}
		
		@Override
		@RosettaAttribute("triggerType")
		public TriggerTypeEnum getTriggerType() {
			return triggerType;
		}
		
		@Override
		@RosettaAttribute("triggerTimeType")
		public TriggerTimeTypeEnum getTriggerTimeType() {
			return triggerTimeType;
		}
		
		@Override
		public Trigger build() {
			return this;
		}
		
		@Override
		public Trigger.TriggerBuilder toBuilder() {
			Trigger.TriggerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Trigger.TriggerBuilder builder) {
			ofNullable(getLevel()).ifPresent(builder::setLevel);
			ofNullable(getLevelPercentage()).ifPresent(builder::setLevelPercentage);
			ofNullable(getTriggerChoice()).ifPresent(builder::setTriggerChoice);
			ofNullable(getTriggerType()).ifPresent(builder::setTriggerType);
			ofNullable(getTriggerTimeType()).ifPresent(builder::setTriggerTimeType);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trigger _that = getType().cast(o);
		
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(triggerChoice, _that.getTriggerChoice())) return false;
			if (!Objects.equals(triggerType, _that.getTriggerType())) return false;
			if (!Objects.equals(triggerTimeType, _that.getTriggerTimeType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (triggerChoice != null ? triggerChoice.hashCode() : 0);
			_result = 31 * _result + (triggerType != null ? triggerType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (triggerTimeType != null ? triggerTimeType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Trigger {" +
				"level=" + this.level + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"triggerChoice=" + this.triggerChoice + ", " +
				"triggerType=" + this.triggerType + ", " +
				"triggerTimeType=" + this.triggerTimeType +
			'}';
		}
	}

	/*********************** Builder Implementation of Trigger  ***********************/
	class TriggerBuilderImpl implements Trigger.TriggerBuilder {
	
		protected BigDecimal level;
		protected BigDecimal levelPercentage;
		protected TriggerChoice.TriggerChoiceBuilder triggerChoice;
		protected TriggerTypeEnum triggerType;
		protected TriggerTimeTypeEnum triggerTimeType;
	
		public TriggerBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("level")
		public BigDecimal getLevel() {
			return level;
		}
		
		@Override
		@RosettaAttribute("levelPercentage")
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		@RosettaAttribute("triggerChoice")
		public TriggerChoice.TriggerChoiceBuilder getTriggerChoice() {
			return triggerChoice;
		}
		
		@Override
		public TriggerChoice.TriggerChoiceBuilder getOrCreateTriggerChoice() {
			TriggerChoice.TriggerChoiceBuilder result;
			if (triggerChoice!=null) {
				result = triggerChoice;
			}
			else {
				result = triggerChoice = TriggerChoice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("triggerType")
		public TriggerTypeEnum getTriggerType() {
			return triggerType;
		}
		
		@Override
		@RosettaAttribute("triggerTimeType")
		public TriggerTimeTypeEnum getTriggerTimeType() {
			return triggerTimeType;
		}
		
		@Override
		@RosettaAttribute("level")
		public Trigger.TriggerBuilder setLevel(BigDecimal level) {
			this.level = level==null?null:level;
			return this;
		}
		@Override
		@RosettaAttribute("levelPercentage")
		public Trigger.TriggerBuilder setLevelPercentage(BigDecimal levelPercentage) {
			this.levelPercentage = levelPercentage==null?null:levelPercentage;
			return this;
		}
		@Override
		@RosettaAttribute("triggerChoice")
		public Trigger.TriggerBuilder setTriggerChoice(TriggerChoice triggerChoice) {
			this.triggerChoice = triggerChoice==null?null:triggerChoice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("triggerType")
		public Trigger.TriggerBuilder setTriggerType(TriggerTypeEnum triggerType) {
			this.triggerType = triggerType==null?null:triggerType;
			return this;
		}
		@Override
		@RosettaAttribute("triggerTimeType")
		public Trigger.TriggerBuilder setTriggerTimeType(TriggerTimeTypeEnum triggerTimeType) {
			this.triggerTimeType = triggerTimeType==null?null:triggerTimeType;
			return this;
		}
		
		@Override
		public Trigger build() {
			return new Trigger.TriggerImpl(this);
		}
		
		@Override
		public Trigger.TriggerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trigger.TriggerBuilder prune() {
			if (triggerChoice!=null && !triggerChoice.prune().hasData()) triggerChoice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLevel()!=null) return true;
			if (getLevelPercentage()!=null) return true;
			if (getTriggerChoice()!=null && getTriggerChoice().hasData()) return true;
			if (getTriggerType()!=null) return true;
			if (getTriggerTimeType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Trigger.TriggerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Trigger.TriggerBuilder o = (Trigger.TriggerBuilder) other;
			
			merger.mergeRosetta(getTriggerChoice(), o.getTriggerChoice(), this::setTriggerChoice);
			
			merger.mergeBasic(getLevel(), o.getLevel(), this::setLevel);
			merger.mergeBasic(getLevelPercentage(), o.getLevelPercentage(), this::setLevelPercentage);
			merger.mergeBasic(getTriggerType(), o.getTriggerType(), this::setTriggerType);
			merger.mergeBasic(getTriggerTimeType(), o.getTriggerTimeType(), this::setTriggerTimeType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Trigger _that = getType().cast(o);
		
			if (!Objects.equals(level, _that.getLevel())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(triggerChoice, _that.getTriggerChoice())) return false;
			if (!Objects.equals(triggerType, _that.getTriggerType())) return false;
			if (!Objects.equals(triggerTimeType, _that.getTriggerTimeType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (level != null ? level.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (triggerChoice != null ? triggerChoice.hashCode() : 0);
			_result = 31 * _result + (triggerType != null ? triggerType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (triggerTimeType != null ? triggerTimeType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TriggerBuilder {" +
				"level=" + this.level + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"triggerChoice=" + this.triggerChoice + ", " +
				"triggerType=" + this.triggerType + ", " +
				"triggerTimeType=" + this.triggerTimeType +
			'}';
		}
	}
}
