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
import fpml.confirmation.AbsoluteTolerance;
import fpml.confirmation.AbsoluteTolerance.AbsoluteToleranceBuilder;
import fpml.confirmation.AbsoluteTolerance.AbsoluteToleranceBuilderImpl;
import fpml.confirmation.AbsoluteTolerance.AbsoluteToleranceImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.QuantityUnit;
import fpml.confirmation.meta.AbsoluteToleranceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The acceptable tolerance in the delivered quantity of a physical commodity product in terms of a number of units of that product.
 * @version ${project.version}
 */
@RosettaDataType(value="AbsoluteTolerance", builder=AbsoluteTolerance.AbsoluteToleranceBuilderImpl.class, version="${project.version}")
public interface AbsoluteTolerance extends RosettaModelObject {

	AbsoluteToleranceMeta metaData = new AbsoluteToleranceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The maxmium amount by which the quantity delivered can exceed the agreed quantity.
	 */
	BigDecimal getPositive();
	/**
	 * The maximum amount by which the quantity delivered can be less than the agreed quantity.
	 */
	BigDecimal getNegative();
	/**
	 * The unit in which the tolerance is specified.
	 */
	QuantityUnit getUnit();
	/**
	 * Indicates whether the tolerance is at the seller&#39;s or buyer&#39;s option.
	 */
	PartyReference getOptionOwnerPartyReference();

	/*********************** Build Methods  ***********************/
	AbsoluteTolerance build();
	
	AbsoluteTolerance.AbsoluteToleranceBuilder toBuilder();
	
	static AbsoluteTolerance.AbsoluteToleranceBuilder builder() {
		return new AbsoluteTolerance.AbsoluteToleranceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbsoluteTolerance> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AbsoluteTolerance> getType() {
		return AbsoluteTolerance.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("positive"), BigDecimal.class, getPositive(), this);
		processor.processBasic(path.newSubPath("negative"), BigDecimal.class, getNegative(), this);
		processRosetta(path.newSubPath("unit"), processor, QuantityUnit.class, getUnit());
		processRosetta(path.newSubPath("optionOwnerPartyReference"), processor, PartyReference.class, getOptionOwnerPartyReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbsoluteToleranceBuilder extends AbsoluteTolerance, RosettaModelObjectBuilder {
		QuantityUnit.QuantityUnitBuilder getOrCreateUnit();
		QuantityUnit.QuantityUnitBuilder getUnit();
		PartyReference.PartyReferenceBuilder getOrCreateOptionOwnerPartyReference();
		PartyReference.PartyReferenceBuilder getOptionOwnerPartyReference();
		AbsoluteTolerance.AbsoluteToleranceBuilder setPositive(BigDecimal positive);
		AbsoluteTolerance.AbsoluteToleranceBuilder setNegative(BigDecimal negative);
		AbsoluteTolerance.AbsoluteToleranceBuilder setUnit(QuantityUnit unit);
		AbsoluteTolerance.AbsoluteToleranceBuilder setOptionOwnerPartyReference(PartyReference optionOwnerPartyReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("positive"), BigDecimal.class, getPositive(), this);
			processor.processBasic(path.newSubPath("negative"), BigDecimal.class, getNegative(), this);
			processRosetta(path.newSubPath("unit"), processor, QuantityUnit.QuantityUnitBuilder.class, getUnit());
			processRosetta(path.newSubPath("optionOwnerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getOptionOwnerPartyReference());
		}
		

		AbsoluteTolerance.AbsoluteToleranceBuilder prune();
	}

	/*********************** Immutable Implementation of AbsoluteTolerance  ***********************/
	class AbsoluteToleranceImpl implements AbsoluteTolerance {
		private final BigDecimal positive;
		private final BigDecimal negative;
		private final QuantityUnit unit;
		private final PartyReference optionOwnerPartyReference;
		
		protected AbsoluteToleranceImpl(AbsoluteTolerance.AbsoluteToleranceBuilder builder) {
			this.positive = builder.getPositive();
			this.negative = builder.getNegative();
			this.unit = ofNullable(builder.getUnit()).map(f->f.build()).orElse(null);
			this.optionOwnerPartyReference = ofNullable(builder.getOptionOwnerPartyReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("positive")
		public BigDecimal getPositive() {
			return positive;
		}
		
		@Override
		@RosettaAttribute("negative")
		public BigDecimal getNegative() {
			return negative;
		}
		
		@Override
		@RosettaAttribute("unit")
		public QuantityUnit getUnit() {
			return unit;
		}
		
		@Override
		@RosettaAttribute("optionOwnerPartyReference")
		public PartyReference getOptionOwnerPartyReference() {
			return optionOwnerPartyReference;
		}
		
		@Override
		public AbsoluteTolerance build() {
			return this;
		}
		
		@Override
		public AbsoluteTolerance.AbsoluteToleranceBuilder toBuilder() {
			AbsoluteTolerance.AbsoluteToleranceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbsoluteTolerance.AbsoluteToleranceBuilder builder) {
			ofNullable(getPositive()).ifPresent(builder::setPositive);
			ofNullable(getNegative()).ifPresent(builder::setNegative);
			ofNullable(getUnit()).ifPresent(builder::setUnit);
			ofNullable(getOptionOwnerPartyReference()).ifPresent(builder::setOptionOwnerPartyReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbsoluteTolerance _that = getType().cast(o);
		
			if (!Objects.equals(positive, _that.getPositive())) return false;
			if (!Objects.equals(negative, _that.getNegative())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			if (!Objects.equals(optionOwnerPartyReference, _that.getOptionOwnerPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (positive != null ? positive.hashCode() : 0);
			_result = 31 * _result + (negative != null ? negative.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (optionOwnerPartyReference != null ? optionOwnerPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbsoluteTolerance {" +
				"positive=" + this.positive + ", " +
				"negative=" + this.negative + ", " +
				"unit=" + this.unit + ", " +
				"optionOwnerPartyReference=" + this.optionOwnerPartyReference +
			'}';
		}
	}

	/*********************** Builder Implementation of AbsoluteTolerance  ***********************/
	class AbsoluteToleranceBuilderImpl implements AbsoluteTolerance.AbsoluteToleranceBuilder {
	
		protected BigDecimal positive;
		protected BigDecimal negative;
		protected QuantityUnit.QuantityUnitBuilder unit;
		protected PartyReference.PartyReferenceBuilder optionOwnerPartyReference;
	
		public AbsoluteToleranceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("positive")
		public BigDecimal getPositive() {
			return positive;
		}
		
		@Override
		@RosettaAttribute("negative")
		public BigDecimal getNegative() {
			return negative;
		}
		
		@Override
		@RosettaAttribute("unit")
		public QuantityUnit.QuantityUnitBuilder getUnit() {
			return unit;
		}
		
		@Override
		public QuantityUnit.QuantityUnitBuilder getOrCreateUnit() {
			QuantityUnit.QuantityUnitBuilder result;
			if (unit!=null) {
				result = unit;
			}
			else {
				result = unit = QuantityUnit.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionOwnerPartyReference")
		public PartyReference.PartyReferenceBuilder getOptionOwnerPartyReference() {
			return optionOwnerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOptionOwnerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (optionOwnerPartyReference!=null) {
				result = optionOwnerPartyReference;
			}
			else {
				result = optionOwnerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("positive")
		public AbsoluteTolerance.AbsoluteToleranceBuilder setPositive(BigDecimal positive) {
			this.positive = positive==null?null:positive;
			return this;
		}
		@Override
		@RosettaAttribute("negative")
		public AbsoluteTolerance.AbsoluteToleranceBuilder setNegative(BigDecimal negative) {
			this.negative = negative==null?null:negative;
			return this;
		}
		@Override
		@RosettaAttribute("unit")
		public AbsoluteTolerance.AbsoluteToleranceBuilder setUnit(QuantityUnit unit) {
			this.unit = unit==null?null:unit.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionOwnerPartyReference")
		public AbsoluteTolerance.AbsoluteToleranceBuilder setOptionOwnerPartyReference(PartyReference optionOwnerPartyReference) {
			this.optionOwnerPartyReference = optionOwnerPartyReference==null?null:optionOwnerPartyReference.toBuilder();
			return this;
		}
		
		@Override
		public AbsoluteTolerance build() {
			return new AbsoluteTolerance.AbsoluteToleranceImpl(this);
		}
		
		@Override
		public AbsoluteTolerance.AbsoluteToleranceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbsoluteTolerance.AbsoluteToleranceBuilder prune() {
			if (unit!=null && !unit.prune().hasData()) unit = null;
			if (optionOwnerPartyReference!=null && !optionOwnerPartyReference.prune().hasData()) optionOwnerPartyReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPositive()!=null) return true;
			if (getNegative()!=null) return true;
			if (getUnit()!=null && getUnit().hasData()) return true;
			if (getOptionOwnerPartyReference()!=null && getOptionOwnerPartyReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbsoluteTolerance.AbsoluteToleranceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbsoluteTolerance.AbsoluteToleranceBuilder o = (AbsoluteTolerance.AbsoluteToleranceBuilder) other;
			
			merger.mergeRosetta(getUnit(), o.getUnit(), this::setUnit);
			merger.mergeRosetta(getOptionOwnerPartyReference(), o.getOptionOwnerPartyReference(), this::setOptionOwnerPartyReference);
			
			merger.mergeBasic(getPositive(), o.getPositive(), this::setPositive);
			merger.mergeBasic(getNegative(), o.getNegative(), this::setNegative);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbsoluteTolerance _that = getType().cast(o);
		
			if (!Objects.equals(positive, _that.getPositive())) return false;
			if (!Objects.equals(negative, _that.getNegative())) return false;
			if (!Objects.equals(unit, _that.getUnit())) return false;
			if (!Objects.equals(optionOwnerPartyReference, _that.getOptionOwnerPartyReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (positive != null ? positive.hashCode() : 0);
			_result = 31 * _result + (negative != null ? negative.hashCode() : 0);
			_result = 31 * _result + (unit != null ? unit.hashCode() : 0);
			_result = 31 * _result + (optionOwnerPartyReference != null ? optionOwnerPartyReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbsoluteToleranceBuilder {" +
				"positive=" + this.positive + ", " +
				"negative=" + this.negative + ", " +
				"unit=" + this.unit + ", " +
				"optionOwnerPartyReference=" + this.optionOwnerPartyReference +
			'}';
		}
	}
}
