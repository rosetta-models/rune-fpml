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
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2;
import fpml.confirmation.Compounding;
import fpml.confirmation.Compounding.CompoundingBuilder;
import fpml.confirmation.Compounding.CompoundingBuilderImpl;
import fpml.confirmation.Compounding.CompoundingImpl;
import fpml.confirmation.CompoundingMethodEnum;
import fpml.confirmation.CompoundingRate;
import fpml.confirmation.meta.CompoundingMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the compounding method and the compounding rate.
 * @version ${project.version}
 */
@RosettaDataType(value="Compounding", builder=Compounding.CompoundingBuilderImpl.class, version="${project.version}")
public interface Compounding extends RosettaModelObject {

	CompoundingMeta metaData = new CompoundingMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If more that one calculation period contributes to a single payment amount this element specifies whether compounding is applicable, and if so, what compounding method is to be used. This element must only be included when more that one calculation period contributes to a single payment amount.
	 */
	CompoundingMethodEnum getCompoundingMethod();
	/**
	 * Defines a compounding rate. The compounding interest can either point back to the interest calculation node on the Interest Leg, or be defined specifically.
	 */
	CompoundingRate getCompoundingRate();
	/**
	 * Defines the spread to be used for compounding. This field should be used in scenarios where the interest payment is based on a compounding formula that uses a compounding spread in addition to the regular spread.
	 */
	BigDecimal getCompoundingSpread();
	/**
	 * Defines the compounding dates.
	 */
	AdjustableRelativeOrPeriodicDates2 getCompoundingDates();

	/*********************** Build Methods  ***********************/
	Compounding build();
	
	Compounding.CompoundingBuilder toBuilder();
	
	static Compounding.CompoundingBuilder builder() {
		return new Compounding.CompoundingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Compounding> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Compounding> getType() {
		return Compounding.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("compoundingMethod"), CompoundingMethodEnum.class, getCompoundingMethod(), this);
		processRosetta(path.newSubPath("compoundingRate"), processor, CompoundingRate.class, getCompoundingRate());
		processor.processBasic(path.newSubPath("compoundingSpread"), BigDecimal.class, getCompoundingSpread(), this);
		processRosetta(path.newSubPath("compoundingDates"), processor, AdjustableRelativeOrPeriodicDates2.class, getCompoundingDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompoundingBuilder extends Compounding, RosettaModelObjectBuilder {
		CompoundingRate.CompoundingRateBuilder getOrCreateCompoundingRate();
		CompoundingRate.CompoundingRateBuilder getCompoundingRate();
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getOrCreateCompoundingDates();
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getCompoundingDates();
		Compounding.CompoundingBuilder setCompoundingMethod(CompoundingMethodEnum compoundingMethod);
		Compounding.CompoundingBuilder setCompoundingRate(CompoundingRate compoundingRate);
		Compounding.CompoundingBuilder setCompoundingSpread(BigDecimal compoundingSpread);
		Compounding.CompoundingBuilder setCompoundingDates(AdjustableRelativeOrPeriodicDates2 compoundingDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("compoundingMethod"), CompoundingMethodEnum.class, getCompoundingMethod(), this);
			processRosetta(path.newSubPath("compoundingRate"), processor, CompoundingRate.CompoundingRateBuilder.class, getCompoundingRate());
			processor.processBasic(path.newSubPath("compoundingSpread"), BigDecimal.class, getCompoundingSpread(), this);
			processRosetta(path.newSubPath("compoundingDates"), processor, AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder.class, getCompoundingDates());
		}
		

		Compounding.CompoundingBuilder prune();
	}

	/*********************** Immutable Implementation of Compounding  ***********************/
	class CompoundingImpl implements Compounding {
		private final CompoundingMethodEnum compoundingMethod;
		private final CompoundingRate compoundingRate;
		private final BigDecimal compoundingSpread;
		private final AdjustableRelativeOrPeriodicDates2 compoundingDates;
		
		protected CompoundingImpl(Compounding.CompoundingBuilder builder) {
			this.compoundingMethod = builder.getCompoundingMethod();
			this.compoundingRate = ofNullable(builder.getCompoundingRate()).map(f->f.build()).orElse(null);
			this.compoundingSpread = builder.getCompoundingSpread();
			this.compoundingDates = ofNullable(builder.getCompoundingDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("compoundingMethod")
		public CompoundingMethodEnum getCompoundingMethod() {
			return compoundingMethod;
		}
		
		@Override
		@RosettaAttribute("compoundingRate")
		public CompoundingRate getCompoundingRate() {
			return compoundingRate;
		}
		
		@Override
		@RosettaAttribute("compoundingSpread")
		public BigDecimal getCompoundingSpread() {
			return compoundingSpread;
		}
		
		@Override
		@RosettaAttribute("compoundingDates")
		public AdjustableRelativeOrPeriodicDates2 getCompoundingDates() {
			return compoundingDates;
		}
		
		@Override
		public Compounding build() {
			return this;
		}
		
		@Override
		public Compounding.CompoundingBuilder toBuilder() {
			Compounding.CompoundingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Compounding.CompoundingBuilder builder) {
			ofNullable(getCompoundingMethod()).ifPresent(builder::setCompoundingMethod);
			ofNullable(getCompoundingRate()).ifPresent(builder::setCompoundingRate);
			ofNullable(getCompoundingSpread()).ifPresent(builder::setCompoundingSpread);
			ofNullable(getCompoundingDates()).ifPresent(builder::setCompoundingDates);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Compounding _that = getType().cast(o);
		
			if (!Objects.equals(compoundingMethod, _that.getCompoundingMethod())) return false;
			if (!Objects.equals(compoundingRate, _that.getCompoundingRate())) return false;
			if (!Objects.equals(compoundingSpread, _that.getCompoundingSpread())) return false;
			if (!Objects.equals(compoundingDates, _that.getCompoundingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compoundingMethod != null ? compoundingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (compoundingRate != null ? compoundingRate.hashCode() : 0);
			_result = 31 * _result + (compoundingSpread != null ? compoundingSpread.hashCode() : 0);
			_result = 31 * _result + (compoundingDates != null ? compoundingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Compounding {" +
				"compoundingMethod=" + this.compoundingMethod + ", " +
				"compoundingRate=" + this.compoundingRate + ", " +
				"compoundingSpread=" + this.compoundingSpread + ", " +
				"compoundingDates=" + this.compoundingDates +
			'}';
		}
	}

	/*********************** Builder Implementation of Compounding  ***********************/
	class CompoundingBuilderImpl implements Compounding.CompoundingBuilder {
	
		protected CompoundingMethodEnum compoundingMethod;
		protected CompoundingRate.CompoundingRateBuilder compoundingRate;
		protected BigDecimal compoundingSpread;
		protected AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder compoundingDates;
	
		public CompoundingBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("compoundingMethod")
		public CompoundingMethodEnum getCompoundingMethod() {
			return compoundingMethod;
		}
		
		@Override
		@RosettaAttribute("compoundingRate")
		public CompoundingRate.CompoundingRateBuilder getCompoundingRate() {
			return compoundingRate;
		}
		
		@Override
		public CompoundingRate.CompoundingRateBuilder getOrCreateCompoundingRate() {
			CompoundingRate.CompoundingRateBuilder result;
			if (compoundingRate!=null) {
				result = compoundingRate;
			}
			else {
				result = compoundingRate = CompoundingRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compoundingSpread")
		public BigDecimal getCompoundingSpread() {
			return compoundingSpread;
		}
		
		@Override
		@RosettaAttribute("compoundingDates")
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getCompoundingDates() {
			return compoundingDates;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder getOrCreateCompoundingDates() {
			AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder result;
			if (compoundingDates!=null) {
				result = compoundingDates;
			}
			else {
				result = compoundingDates = AdjustableRelativeOrPeriodicDates2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compoundingMethod")
		public Compounding.CompoundingBuilder setCompoundingMethod(CompoundingMethodEnum compoundingMethod) {
			this.compoundingMethod = compoundingMethod==null?null:compoundingMethod;
			return this;
		}
		@Override
		@RosettaAttribute("compoundingRate")
		public Compounding.CompoundingBuilder setCompoundingRate(CompoundingRate compoundingRate) {
			this.compoundingRate = compoundingRate==null?null:compoundingRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("compoundingSpread")
		public Compounding.CompoundingBuilder setCompoundingSpread(BigDecimal compoundingSpread) {
			this.compoundingSpread = compoundingSpread==null?null:compoundingSpread;
			return this;
		}
		@Override
		@RosettaAttribute("compoundingDates")
		public Compounding.CompoundingBuilder setCompoundingDates(AdjustableRelativeOrPeriodicDates2 compoundingDates) {
			this.compoundingDates = compoundingDates==null?null:compoundingDates.toBuilder();
			return this;
		}
		
		@Override
		public Compounding build() {
			return new Compounding.CompoundingImpl(this);
		}
		
		@Override
		public Compounding.CompoundingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Compounding.CompoundingBuilder prune() {
			if (compoundingRate!=null && !compoundingRate.prune().hasData()) compoundingRate = null;
			if (compoundingDates!=null && !compoundingDates.prune().hasData()) compoundingDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCompoundingMethod()!=null) return true;
			if (getCompoundingRate()!=null && getCompoundingRate().hasData()) return true;
			if (getCompoundingSpread()!=null) return true;
			if (getCompoundingDates()!=null && getCompoundingDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Compounding.CompoundingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Compounding.CompoundingBuilder o = (Compounding.CompoundingBuilder) other;
			
			merger.mergeRosetta(getCompoundingRate(), o.getCompoundingRate(), this::setCompoundingRate);
			merger.mergeRosetta(getCompoundingDates(), o.getCompoundingDates(), this::setCompoundingDates);
			
			merger.mergeBasic(getCompoundingMethod(), o.getCompoundingMethod(), this::setCompoundingMethod);
			merger.mergeBasic(getCompoundingSpread(), o.getCompoundingSpread(), this::setCompoundingSpread);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Compounding _that = getType().cast(o);
		
			if (!Objects.equals(compoundingMethod, _that.getCompoundingMethod())) return false;
			if (!Objects.equals(compoundingRate, _that.getCompoundingRate())) return false;
			if (!Objects.equals(compoundingSpread, _that.getCompoundingSpread())) return false;
			if (!Objects.equals(compoundingDates, _that.getCompoundingDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compoundingMethod != null ? compoundingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (compoundingRate != null ? compoundingRate.hashCode() : 0);
			_result = 31 * _result + (compoundingSpread != null ? compoundingSpread.hashCode() : 0);
			_result = 31 * _result + (compoundingDates != null ? compoundingDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompoundingBuilder {" +
				"compoundingMethod=" + this.compoundingMethod + ", " +
				"compoundingRate=" + this.compoundingRate + ", " +
				"compoundingSpread=" + this.compoundingSpread + ", " +
				"compoundingDates=" + this.compoundingDates +
			'}';
		}
	}
}
