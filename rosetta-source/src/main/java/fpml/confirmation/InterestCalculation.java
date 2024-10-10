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
import fpml.confirmation.Compounding;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.InterestAccrualsMethod;
import fpml.confirmation.InterestAccrualsMethod.InterestAccrualsMethodBuilder;
import fpml.confirmation.InterestAccrualsMethod.InterestAccrualsMethodBuilderImpl;
import fpml.confirmation.InterestAccrualsMethod.InterestAccrualsMethodImpl;
import fpml.confirmation.InterestCalculation;
import fpml.confirmation.InterestCalculation.InterestCalculationBuilder;
import fpml.confirmation.InterestCalculation.InterestCalculationBuilderImpl;
import fpml.confirmation.InterestCalculation.InterestCalculationImpl;
import fpml.confirmation.InterestCalculationSequence;
import fpml.confirmation.meta.InterestCalculationMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the calculation method of the interest rate leg of the return swap. Includes the floating or fixed rate calculation definitions, along with the determination of the day count fraction.
 * @version ${project.version}
 */
@RosettaDataType(value="InterestCalculation", builder=InterestCalculation.InterestCalculationBuilderImpl.class, version="${project.version}")
public interface InterestCalculation extends InterestAccrualsMethod {

	InterestCalculationMeta metaData = new InterestCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The day count fraction.
	 */
	DayCountFraction getDayCountFraction();
	/**
	 * Defines compounding rates on the Interest Leg.
	 */
	Compounding getCompounding();
	InterestCalculationSequence getInterestCalculationSequence();
	String getId();

	/*********************** Build Methods  ***********************/
	InterestCalculation build();
	
	InterestCalculation.InterestCalculationBuilder toBuilder();
	
	static InterestCalculation.InterestCalculationBuilder builder() {
		return new InterestCalculation.InterestCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestCalculation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestCalculation> getType() {
		return InterestCalculation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.class, getFloatingRateCalculation());
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.class, getDayCountFraction());
		processRosetta(path.newSubPath("compounding"), processor, Compounding.class, getCompounding());
		processRosetta(path.newSubPath("interestCalculationSequence"), processor, InterestCalculationSequence.class, getInterestCalculationSequence());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestCalculationBuilder extends InterestCalculation, InterestAccrualsMethod.InterestAccrualsMethodBuilder {
		DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction();
		DayCountFraction.DayCountFractionBuilder getDayCountFraction();
		Compounding.CompoundingBuilder getOrCreateCompounding();
		Compounding.CompoundingBuilder getCompounding();
		InterestCalculationSequence.InterestCalculationSequenceBuilder getOrCreateInterestCalculationSequence();
		InterestCalculationSequence.InterestCalculationSequenceBuilder getInterestCalculationSequence();
		InterestCalculation.InterestCalculationBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation);
		InterestCalculation.InterestCalculationBuilder setFixedRate(BigDecimal fixedRate);
		InterestCalculation.InterestCalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction);
		InterestCalculation.InterestCalculationBuilder setCompounding(Compounding compounding);
		InterestCalculation.InterestCalculationBuilder setInterestCalculationSequence(InterestCalculationSequence interestCalculationSequence);
		InterestCalculation.InterestCalculationBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.FloatingRateCalculationBuilder.class, getFloatingRateCalculation());
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processRosetta(path.newSubPath("dayCountFraction"), processor, DayCountFraction.DayCountFractionBuilder.class, getDayCountFraction());
			processRosetta(path.newSubPath("compounding"), processor, Compounding.CompoundingBuilder.class, getCompounding());
			processRosetta(path.newSubPath("interestCalculationSequence"), processor, InterestCalculationSequence.InterestCalculationSequenceBuilder.class, getInterestCalculationSequence());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		InterestCalculation.InterestCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of InterestCalculation  ***********************/
	class InterestCalculationImpl extends InterestAccrualsMethod.InterestAccrualsMethodImpl implements InterestCalculation {
		private final DayCountFraction dayCountFraction;
		private final Compounding compounding;
		private final InterestCalculationSequence interestCalculationSequence;
		private final String id;
		
		protected InterestCalculationImpl(InterestCalculation.InterestCalculationBuilder builder) {
			super(builder);
			this.dayCountFraction = ofNullable(builder.getDayCountFraction()).map(f->f.build()).orElse(null);
			this.compounding = ofNullable(builder.getCompounding()).map(f->f.build()).orElse(null);
			this.interestCalculationSequence = ofNullable(builder.getInterestCalculationSequence()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("compounding")
		public Compounding getCompounding() {
			return compounding;
		}
		
		@Override
		@RosettaAttribute("interestCalculationSequence")
		public InterestCalculationSequence getInterestCalculationSequence() {
			return interestCalculationSequence;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public InterestCalculation build() {
			return this;
		}
		
		@Override
		public InterestCalculation.InterestCalculationBuilder toBuilder() {
			InterestCalculation.InterestCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestCalculation.InterestCalculationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getCompounding()).ifPresent(builder::setCompounding);
			ofNullable(getInterestCalculationSequence()).ifPresent(builder::setInterestCalculationSequence);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestCalculation _that = getType().cast(o);
		
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(compounding, _that.getCompounding())) return false;
			if (!Objects.equals(interestCalculationSequence, _that.getInterestCalculationSequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (compounding != null ? compounding.hashCode() : 0);
			_result = 31 * _result + (interestCalculationSequence != null ? interestCalculationSequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestCalculation {" +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"compounding=" + this.compounding + ", " +
				"interestCalculationSequence=" + this.interestCalculationSequence + ", " +
				"id=" + this.id +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestCalculation  ***********************/
	class InterestCalculationBuilderImpl extends InterestAccrualsMethod.InterestAccrualsMethodBuilderImpl  implements InterestCalculation.InterestCalculationBuilder {
	
		protected DayCountFraction.DayCountFractionBuilder dayCountFraction;
		protected Compounding.CompoundingBuilder compounding;
		protected InterestCalculationSequence.InterestCalculationSequenceBuilder interestCalculationSequence;
		protected String id;
	
		public InterestCalculationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dayCountFraction")
		public DayCountFraction.DayCountFractionBuilder getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		public DayCountFraction.DayCountFractionBuilder getOrCreateDayCountFraction() {
			DayCountFraction.DayCountFractionBuilder result;
			if (dayCountFraction!=null) {
				result = dayCountFraction;
			}
			else {
				result = dayCountFraction = DayCountFraction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("compounding")
		public Compounding.CompoundingBuilder getCompounding() {
			return compounding;
		}
		
		@Override
		public Compounding.CompoundingBuilder getOrCreateCompounding() {
			Compounding.CompoundingBuilder result;
			if (compounding!=null) {
				result = compounding;
			}
			else {
				result = compounding = Compounding.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestCalculationSequence")
		public InterestCalculationSequence.InterestCalculationSequenceBuilder getInterestCalculationSequence() {
			return interestCalculationSequence;
		}
		
		@Override
		public InterestCalculationSequence.InterestCalculationSequenceBuilder getOrCreateInterestCalculationSequence() {
			InterestCalculationSequence.InterestCalculationSequenceBuilder result;
			if (interestCalculationSequence!=null) {
				result = interestCalculationSequence;
			}
			else {
				result = interestCalculationSequence = InterestCalculationSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("floatingRateCalculation")
		public InterestCalculation.InterestCalculationBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation) {
			this.floatingRateCalculation = floatingRateCalculation==null?null:floatingRateCalculation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedRate")
		public InterestCalculation.InterestCalculationBuilder setFixedRate(BigDecimal fixedRate) {
			this.fixedRate = fixedRate==null?null:fixedRate;
			return this;
		}
		@Override
		@RosettaAttribute("dayCountFraction")
		public InterestCalculation.InterestCalculationBuilder setDayCountFraction(DayCountFraction dayCountFraction) {
			this.dayCountFraction = dayCountFraction==null?null:dayCountFraction.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("compounding")
		public InterestCalculation.InterestCalculationBuilder setCompounding(Compounding compounding) {
			this.compounding = compounding==null?null:compounding.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interestCalculationSequence")
		public InterestCalculation.InterestCalculationBuilder setInterestCalculationSequence(InterestCalculationSequence interestCalculationSequence) {
			this.interestCalculationSequence = interestCalculationSequence==null?null:interestCalculationSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public InterestCalculation.InterestCalculationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public InterestCalculation build() {
			return new InterestCalculation.InterestCalculationImpl(this);
		}
		
		@Override
		public InterestCalculation.InterestCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestCalculation.InterestCalculationBuilder prune() {
			super.prune();
			if (dayCountFraction!=null && !dayCountFraction.prune().hasData()) dayCountFraction = null;
			if (compounding!=null && !compounding.prune().hasData()) compounding = null;
			if (interestCalculationSequence!=null && !interestCalculationSequence.prune().hasData()) interestCalculationSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDayCountFraction()!=null && getDayCountFraction().hasData()) return true;
			if (getCompounding()!=null && getCompounding().hasData()) return true;
			if (getInterestCalculationSequence()!=null && getInterestCalculationSequence().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestCalculation.InterestCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InterestCalculation.InterestCalculationBuilder o = (InterestCalculation.InterestCalculationBuilder) other;
			
			merger.mergeRosetta(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeRosetta(getCompounding(), o.getCompounding(), this::setCompounding);
			merger.mergeRosetta(getInterestCalculationSequence(), o.getInterestCalculationSequence(), this::setInterestCalculationSequence);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestCalculation _that = getType().cast(o);
		
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(compounding, _that.getCompounding())) return false;
			if (!Objects.equals(interestCalculationSequence, _that.getInterestCalculationSequence())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.hashCode() : 0);
			_result = 31 * _result + (compounding != null ? compounding.hashCode() : 0);
			_result = 31 * _result + (interestCalculationSequence != null ? interestCalculationSequence.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestCalculationBuilder {" +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"compounding=" + this.compounding + ", " +
				"interestCalculationSequence=" + this.interestCalculationSequence + ", " +
				"id=" + this.id +
			'}' + " " + super.toString();
		}
	}
}
