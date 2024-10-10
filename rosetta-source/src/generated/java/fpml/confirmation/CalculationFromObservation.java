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
import fpml.confirmation.CalculationFromObservation;
import fpml.confirmation.CalculationFromObservation.CalculationFromObservationBuilder;
import fpml.confirmation.CalculationFromObservation.CalculationFromObservationBuilderImpl;
import fpml.confirmation.CalculationFromObservation.CalculationFromObservationImpl;
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.meta.CalculationFromObservationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Abstract base class for all calculation from observed values.
 * @version ${project.version}
 */
@RosettaDataType(value="CalculationFromObservation", builder=CalculationFromObservation.CalculationFromObservationBuilderImpl.class, version="${project.version}")
public interface CalculationFromObservation extends RosettaModelObject {

	CalculationFromObservationMeta metaData = new CalculationFromObservationMeta();

	/*********************** Getter Methods  ***********************/
	CalculationFromObservationChoice getCalculationFromObservationChoice();
	/**
	 * DEPRECATED. If true this contract will strike off the closing level of the default exchange traded contract.
	 */
	Boolean getClosingLevel();
	/**
	 * DEPRECATED. If true this contract will strike off the expiring level of the default exchange traded contract.
	 */
	Boolean getExpiringLevel();
	/**
	 * Expected number of trading days.
	 */
	Integer getExpectedN();

	/*********************** Build Methods  ***********************/
	CalculationFromObservation build();
	
	CalculationFromObservation.CalculationFromObservationBuilder toBuilder();
	
	static CalculationFromObservation.CalculationFromObservationBuilder builder() {
		return new CalculationFromObservation.CalculationFromObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationFromObservation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculationFromObservation> getType() {
		return CalculationFromObservation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationFromObservationChoice"), processor, CalculationFromObservationChoice.class, getCalculationFromObservationChoice());
		processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
		processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
		processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationFromObservationBuilder extends CalculationFromObservation, RosettaModelObjectBuilder {
		CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder getOrCreateCalculationFromObservationChoice();
		CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder getCalculationFromObservationChoice();
		CalculationFromObservation.CalculationFromObservationBuilder setCalculationFromObservationChoice(CalculationFromObservationChoice calculationFromObservationChoice);
		CalculationFromObservation.CalculationFromObservationBuilder setClosingLevel(Boolean closingLevel);
		CalculationFromObservation.CalculationFromObservationBuilder setExpiringLevel(Boolean expiringLevel);
		CalculationFromObservation.CalculationFromObservationBuilder setExpectedN(Integer expectedN);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationFromObservationChoice"), processor, CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder.class, getCalculationFromObservationChoice());
			processor.processBasic(path.newSubPath("closingLevel"), Boolean.class, getClosingLevel(), this);
			processor.processBasic(path.newSubPath("expiringLevel"), Boolean.class, getExpiringLevel(), this);
			processor.processBasic(path.newSubPath("expectedN"), Integer.class, getExpectedN(), this);
		}
		

		CalculationFromObservation.CalculationFromObservationBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationFromObservation  ***********************/
	class CalculationFromObservationImpl implements CalculationFromObservation {
		private final CalculationFromObservationChoice calculationFromObservationChoice;
		private final Boolean closingLevel;
		private final Boolean expiringLevel;
		private final Integer expectedN;
		
		protected CalculationFromObservationImpl(CalculationFromObservation.CalculationFromObservationBuilder builder) {
			this.calculationFromObservationChoice = ofNullable(builder.getCalculationFromObservationChoice()).map(f->f.build()).orElse(null);
			this.closingLevel = builder.getClosingLevel();
			this.expiringLevel = builder.getExpiringLevel();
			this.expectedN = builder.getExpectedN();
		}
		
		@Override
		@RosettaAttribute("calculationFromObservationChoice")
		public CalculationFromObservationChoice getCalculationFromObservationChoice() {
			return calculationFromObservationChoice;
		}
		
		@Override
		@RosettaAttribute("closingLevel")
		public Boolean getClosingLevel() {
			return closingLevel;
		}
		
		@Override
		@RosettaAttribute("expiringLevel")
		public Boolean getExpiringLevel() {
			return expiringLevel;
		}
		
		@Override
		@RosettaAttribute("expectedN")
		public Integer getExpectedN() {
			return expectedN;
		}
		
		@Override
		public CalculationFromObservation build() {
			return this;
		}
		
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder toBuilder() {
			CalculationFromObservation.CalculationFromObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationFromObservation.CalculationFromObservationBuilder builder) {
			ofNullable(getCalculationFromObservationChoice()).ifPresent(builder::setCalculationFromObservationChoice);
			ofNullable(getClosingLevel()).ifPresent(builder::setClosingLevel);
			ofNullable(getExpiringLevel()).ifPresent(builder::setExpiringLevel);
			ofNullable(getExpectedN()).ifPresent(builder::setExpectedN);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationFromObservation _that = getType().cast(o);
		
			if (!Objects.equals(calculationFromObservationChoice, _that.getCalculationFromObservationChoice())) return false;
			if (!Objects.equals(closingLevel, _that.getClosingLevel())) return false;
			if (!Objects.equals(expiringLevel, _that.getExpiringLevel())) return false;
			if (!Objects.equals(expectedN, _that.getExpectedN())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationFromObservationChoice != null ? calculationFromObservationChoice.hashCode() : 0);
			_result = 31 * _result + (closingLevel != null ? closingLevel.hashCode() : 0);
			_result = 31 * _result + (expiringLevel != null ? expiringLevel.hashCode() : 0);
			_result = 31 * _result + (expectedN != null ? expectedN.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationFromObservation {" +
				"calculationFromObservationChoice=" + this.calculationFromObservationChoice + ", " +
				"closingLevel=" + this.closingLevel + ", " +
				"expiringLevel=" + this.expiringLevel + ", " +
				"expectedN=" + this.expectedN +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationFromObservation  ***********************/
	class CalculationFromObservationBuilderImpl implements CalculationFromObservation.CalculationFromObservationBuilder {
	
		protected CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder calculationFromObservationChoice;
		protected Boolean closingLevel;
		protected Boolean expiringLevel;
		protected Integer expectedN;
	
		public CalculationFromObservationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationFromObservationChoice")
		public CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder getCalculationFromObservationChoice() {
			return calculationFromObservationChoice;
		}
		
		@Override
		public CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder getOrCreateCalculationFromObservationChoice() {
			CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder result;
			if (calculationFromObservationChoice!=null) {
				result = calculationFromObservationChoice;
			}
			else {
				result = calculationFromObservationChoice = CalculationFromObservationChoice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("closingLevel")
		public Boolean getClosingLevel() {
			return closingLevel;
		}
		
		@Override
		@RosettaAttribute("expiringLevel")
		public Boolean getExpiringLevel() {
			return expiringLevel;
		}
		
		@Override
		@RosettaAttribute("expectedN")
		public Integer getExpectedN() {
			return expectedN;
		}
		
		@Override
		@RosettaAttribute("calculationFromObservationChoice")
		public CalculationFromObservation.CalculationFromObservationBuilder setCalculationFromObservationChoice(CalculationFromObservationChoice calculationFromObservationChoice) {
			this.calculationFromObservationChoice = calculationFromObservationChoice==null?null:calculationFromObservationChoice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("closingLevel")
		public CalculationFromObservation.CalculationFromObservationBuilder setClosingLevel(Boolean closingLevel) {
			this.closingLevel = closingLevel==null?null:closingLevel;
			return this;
		}
		@Override
		@RosettaAttribute("expiringLevel")
		public CalculationFromObservation.CalculationFromObservationBuilder setExpiringLevel(Boolean expiringLevel) {
			this.expiringLevel = expiringLevel==null?null:expiringLevel;
			return this;
		}
		@Override
		@RosettaAttribute("expectedN")
		public CalculationFromObservation.CalculationFromObservationBuilder setExpectedN(Integer expectedN) {
			this.expectedN = expectedN==null?null:expectedN;
			return this;
		}
		
		@Override
		public CalculationFromObservation build() {
			return new CalculationFromObservation.CalculationFromObservationImpl(this);
		}
		
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder prune() {
			if (calculationFromObservationChoice!=null && !calculationFromObservationChoice.prune().hasData()) calculationFromObservationChoice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationFromObservationChoice()!=null && getCalculationFromObservationChoice().hasData()) return true;
			if (getClosingLevel()!=null) return true;
			if (getExpiringLevel()!=null) return true;
			if (getExpectedN()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationFromObservation.CalculationFromObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationFromObservation.CalculationFromObservationBuilder o = (CalculationFromObservation.CalculationFromObservationBuilder) other;
			
			merger.mergeRosetta(getCalculationFromObservationChoice(), o.getCalculationFromObservationChoice(), this::setCalculationFromObservationChoice);
			
			merger.mergeBasic(getClosingLevel(), o.getClosingLevel(), this::setClosingLevel);
			merger.mergeBasic(getExpiringLevel(), o.getExpiringLevel(), this::setExpiringLevel);
			merger.mergeBasic(getExpectedN(), o.getExpectedN(), this::setExpectedN);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationFromObservation _that = getType().cast(o);
		
			if (!Objects.equals(calculationFromObservationChoice, _that.getCalculationFromObservationChoice())) return false;
			if (!Objects.equals(closingLevel, _that.getClosingLevel())) return false;
			if (!Objects.equals(expiringLevel, _that.getExpiringLevel())) return false;
			if (!Objects.equals(expectedN, _that.getExpectedN())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationFromObservationChoice != null ? calculationFromObservationChoice.hashCode() : 0);
			_result = 31 * _result + (closingLevel != null ? closingLevel.hashCode() : 0);
			_result = 31 * _result + (expiringLevel != null ? expiringLevel.hashCode() : 0);
			_result = 31 * _result + (expectedN != null ? expectedN.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationFromObservationBuilder {" +
				"calculationFromObservationChoice=" + this.calculationFromObservationChoice + ", " +
				"closingLevel=" + this.closingLevel + ", " +
				"expiringLevel=" + this.expiringLevel + ", " +
				"expectedN=" + this.expectedN +
			'}';
		}
	}
}
