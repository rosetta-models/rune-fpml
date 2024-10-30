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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.DirectionalLeg;
import fpml.confirmation.DirectionalLeg.DirectionalLegBuilder;
import fpml.confirmation.DirectionalLeg.DirectionalLegBuilderImpl;
import fpml.confirmation.DirectionalLeg.DirectionalLegImpl;
import fpml.confirmation.InterestCalculation;
import fpml.confirmation.InterestLeg;
import fpml.confirmation.InterestLeg.InterestLegBuilder;
import fpml.confirmation.InterestLeg.InterestLegBuilderImpl;
import fpml.confirmation.InterestLeg.InterestLegImpl;
import fpml.confirmation.InterestLegCalculationPeriodDates;
import fpml.confirmation.LegAmount;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.ReturnSwapNotional;
import fpml.confirmation.StubCalculationPeriod;
import fpml.confirmation.meta.InterestLegMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * The fixed income amounts of the return type swap. A type describing the fixed income leg of the equity swap.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="InterestLeg", builder=InterestLeg.InterestLegBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface InterestLeg extends DirectionalLeg {

	InterestLegMeta metaData = new InterestLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Component that holds the various dates used to specify the interest leg of the equity swap. It is used to define the InterestPeriodDates identifyer.
	 */
	InterestLegCalculationPeriodDates getInterestLegCalculationPeriodDates();
	/**
	 * Specifies the notional of a return type swap. When used in the equity leg, the definition will typically combine the actual amount (using the notional component defined by the FpML industry group) and the determination method. When used in the interest leg, the definition will typically point to the definition of the equity leg.
	 */
	ReturnSwapNotional getNotional();
	/**
	 * Specifies, in relation to each Interest Payment Date, the amount to which the Interest Payment Date relates. Unless otherwise specified, this term has the meaning defined in the ISDA 2000 ISDA Definitions.
	 */
	LegAmount getInterestAmount();
	/**
	 * Specifies the calculation method of the interest rate leg of the equity swap. Includes the floating or fixed rate calculation definitions, along with the determination of the day count fraction.
	 */
	InterestCalculation getInterestCalculation();
	/**
	 * Specifies the stub calculation period.
	 */
	StubCalculationPeriod getStubCalculationPeriod();

	/*********************** Build Methods  ***********************/
	InterestLeg build();
	
	InterestLeg.InterestLegBuilder toBuilder();
	
	static InterestLeg.InterestLegBuilder builder() {
		return new InterestLeg.InterestLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestLeg> getType() {
		return InterestLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("interestLegCalculationPeriodDates"), processor, InterestLegCalculationPeriodDates.class, getInterestLegCalculationPeriodDates());
		processRosetta(path.newSubPath("notional"), processor, ReturnSwapNotional.class, getNotional());
		processRosetta(path.newSubPath("interestAmount"), processor, LegAmount.class, getInterestAmount());
		processRosetta(path.newSubPath("interestCalculation"), processor, InterestCalculation.class, getInterestCalculation());
		processRosetta(path.newSubPath("stubCalculationPeriod"), processor, StubCalculationPeriod.class, getStubCalculationPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestLegBuilder extends InterestLeg, DirectionalLeg.DirectionalLegBuilder {
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder getOrCreateInterestLegCalculationPeriodDates();
		InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder getInterestLegCalculationPeriodDates();
		ReturnSwapNotional.ReturnSwapNotionalBuilder getOrCreateNotional();
		ReturnSwapNotional.ReturnSwapNotionalBuilder getNotional();
		LegAmount.LegAmountBuilder getOrCreateInterestAmount();
		LegAmount.LegAmountBuilder getInterestAmount();
		InterestCalculation.InterestCalculationBuilder getOrCreateInterestCalculation();
		InterestCalculation.InterestCalculationBuilder getInterestCalculation();
		StubCalculationPeriod.StubCalculationPeriodBuilder getOrCreateStubCalculationPeriod();
		StubCalculationPeriod.StubCalculationPeriodBuilder getStubCalculationPeriod();
		InterestLeg.InterestLegBuilder setId(String id);
		InterestLeg.InterestLegBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		InterestLeg.InterestLegBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		InterestLeg.InterestLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		InterestLeg.InterestLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		InterestLeg.InterestLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		InterestLeg.InterestLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		InterestLeg.InterestLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		InterestLeg.InterestLegBuilder setInterestLegCalculationPeriodDates(InterestLegCalculationPeriodDates interestLegCalculationPeriodDates);
		InterestLeg.InterestLegBuilder setNotional(ReturnSwapNotional notional);
		InterestLeg.InterestLegBuilder setInterestAmount(LegAmount interestAmount);
		InterestLeg.InterestLegBuilder setInterestCalculation(InterestCalculation interestCalculation);
		InterestLeg.InterestLegBuilder setStubCalculationPeriod(StubCalculationPeriod stubCalculationPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("interestLegCalculationPeriodDates"), processor, InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder.class, getInterestLegCalculationPeriodDates());
			processRosetta(path.newSubPath("notional"), processor, ReturnSwapNotional.ReturnSwapNotionalBuilder.class, getNotional());
			processRosetta(path.newSubPath("interestAmount"), processor, LegAmount.LegAmountBuilder.class, getInterestAmount());
			processRosetta(path.newSubPath("interestCalculation"), processor, InterestCalculation.InterestCalculationBuilder.class, getInterestCalculation());
			processRosetta(path.newSubPath("stubCalculationPeriod"), processor, StubCalculationPeriod.StubCalculationPeriodBuilder.class, getStubCalculationPeriod());
		}
		

		InterestLeg.InterestLegBuilder prune();
	}

	/*********************** Immutable Implementation of InterestLeg  ***********************/
	class InterestLegImpl extends DirectionalLeg.DirectionalLegImpl implements InterestLeg {
		private final InterestLegCalculationPeriodDates interestLegCalculationPeriodDates;
		private final ReturnSwapNotional notional;
		private final LegAmount interestAmount;
		private final InterestCalculation interestCalculation;
		private final StubCalculationPeriod stubCalculationPeriod;
		
		protected InterestLegImpl(InterestLeg.InterestLegBuilder builder) {
			super(builder);
			this.interestLegCalculationPeriodDates = ofNullable(builder.getInterestLegCalculationPeriodDates()).map(f->f.build()).orElse(null);
			this.notional = ofNullable(builder.getNotional()).map(f->f.build()).orElse(null);
			this.interestAmount = ofNullable(builder.getInterestAmount()).map(f->f.build()).orElse(null);
			this.interestCalculation = ofNullable(builder.getInterestCalculation()).map(f->f.build()).orElse(null);
			this.stubCalculationPeriod = ofNullable(builder.getStubCalculationPeriod()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("interestLegCalculationPeriodDates")
		public InterestLegCalculationPeriodDates getInterestLegCalculationPeriodDates() {
			return interestLegCalculationPeriodDates;
		}
		
		@Override
		@RosettaAttribute("notional")
		public ReturnSwapNotional getNotional() {
			return notional;
		}
		
		@Override
		@RosettaAttribute("interestAmount")
		public LegAmount getInterestAmount() {
			return interestAmount;
		}
		
		@Override
		@RosettaAttribute("interestCalculation")
		public InterestCalculation getInterestCalculation() {
			return interestCalculation;
		}
		
		@Override
		@RosettaAttribute("stubCalculationPeriod")
		public StubCalculationPeriod getStubCalculationPeriod() {
			return stubCalculationPeriod;
		}
		
		@Override
		public InterestLeg build() {
			return this;
		}
		
		@Override
		public InterestLeg.InterestLegBuilder toBuilder() {
			InterestLeg.InterestLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestLeg.InterestLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInterestLegCalculationPeriodDates()).ifPresent(builder::setInterestLegCalculationPeriodDates);
			ofNullable(getNotional()).ifPresent(builder::setNotional);
			ofNullable(getInterestAmount()).ifPresent(builder::setInterestAmount);
			ofNullable(getInterestCalculation()).ifPresent(builder::setInterestCalculation);
			ofNullable(getStubCalculationPeriod()).ifPresent(builder::setStubCalculationPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestLeg _that = getType().cast(o);
		
			if (!Objects.equals(interestLegCalculationPeriodDates, _that.getInterestLegCalculationPeriodDates())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(interestAmount, _that.getInterestAmount())) return false;
			if (!Objects.equals(interestCalculation, _that.getInterestCalculation())) return false;
			if (!Objects.equals(stubCalculationPeriod, _that.getStubCalculationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (interestLegCalculationPeriodDates != null ? interestLegCalculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (interestAmount != null ? interestAmount.hashCode() : 0);
			_result = 31 * _result + (interestCalculation != null ? interestCalculation.hashCode() : 0);
			_result = 31 * _result + (stubCalculationPeriod != null ? stubCalculationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestLeg {" +
				"interestLegCalculationPeriodDates=" + this.interestLegCalculationPeriodDates + ", " +
				"notional=" + this.notional + ", " +
				"interestAmount=" + this.interestAmount + ", " +
				"interestCalculation=" + this.interestCalculation + ", " +
				"stubCalculationPeriod=" + this.stubCalculationPeriod +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestLeg  ***********************/
	class InterestLegBuilderImpl extends DirectionalLeg.DirectionalLegBuilderImpl  implements InterestLeg.InterestLegBuilder {
	
		protected InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder interestLegCalculationPeriodDates;
		protected ReturnSwapNotional.ReturnSwapNotionalBuilder notional;
		protected LegAmount.LegAmountBuilder interestAmount;
		protected InterestCalculation.InterestCalculationBuilder interestCalculation;
		protected StubCalculationPeriod.StubCalculationPeriodBuilder stubCalculationPeriod;
	
		public InterestLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("interestLegCalculationPeriodDates")
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder getInterestLegCalculationPeriodDates() {
			return interestLegCalculationPeriodDates;
		}
		
		@Override
		public InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder getOrCreateInterestLegCalculationPeriodDates() {
			InterestLegCalculationPeriodDates.InterestLegCalculationPeriodDatesBuilder result;
			if (interestLegCalculationPeriodDates!=null) {
				result = interestLegCalculationPeriodDates;
			}
			else {
				result = interestLegCalculationPeriodDates = InterestLegCalculationPeriodDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notional")
		public ReturnSwapNotional.ReturnSwapNotionalBuilder getNotional() {
			return notional;
		}
		
		@Override
		public ReturnSwapNotional.ReturnSwapNotionalBuilder getOrCreateNotional() {
			ReturnSwapNotional.ReturnSwapNotionalBuilder result;
			if (notional!=null) {
				result = notional;
			}
			else {
				result = notional = ReturnSwapNotional.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestAmount")
		public LegAmount.LegAmountBuilder getInterestAmount() {
			return interestAmount;
		}
		
		@Override
		public LegAmount.LegAmountBuilder getOrCreateInterestAmount() {
			LegAmount.LegAmountBuilder result;
			if (interestAmount!=null) {
				result = interestAmount;
			}
			else {
				result = interestAmount = LegAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestCalculation")
		public InterestCalculation.InterestCalculationBuilder getInterestCalculation() {
			return interestCalculation;
		}
		
		@Override
		public InterestCalculation.InterestCalculationBuilder getOrCreateInterestCalculation() {
			InterestCalculation.InterestCalculationBuilder result;
			if (interestCalculation!=null) {
				result = interestCalculation;
			}
			else {
				result = interestCalculation = InterestCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("stubCalculationPeriod")
		public StubCalculationPeriod.StubCalculationPeriodBuilder getStubCalculationPeriod() {
			return stubCalculationPeriod;
		}
		
		@Override
		public StubCalculationPeriod.StubCalculationPeriodBuilder getOrCreateStubCalculationPeriod() {
			StubCalculationPeriod.StubCalculationPeriodBuilder result;
			if (stubCalculationPeriod!=null) {
				result = stubCalculationPeriod;
			}
			else {
				result = stubCalculationPeriod = StubCalculationPeriod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public InterestLeg.InterestLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("legIdentifier")
		public InterestLeg.InterestLegBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public InterestLeg.InterestLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public InterestLeg.InterestLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public InterestLeg.InterestLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers == null)  {
				this.legIdentifier = new ArrayList<>();
			}
			else {
				this.legIdentifier = legIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public InterestLeg.InterestLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public InterestLeg.InterestLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public InterestLeg.InterestLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interestLegCalculationPeriodDates")
		public InterestLeg.InterestLegBuilder setInterestLegCalculationPeriodDates(InterestLegCalculationPeriodDates interestLegCalculationPeriodDates) {
			this.interestLegCalculationPeriodDates = interestLegCalculationPeriodDates==null?null:interestLegCalculationPeriodDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("notional")
		public InterestLeg.InterestLegBuilder setNotional(ReturnSwapNotional notional) {
			this.notional = notional==null?null:notional.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interestAmount")
		public InterestLeg.InterestLegBuilder setInterestAmount(LegAmount interestAmount) {
			this.interestAmount = interestAmount==null?null:interestAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interestCalculation")
		public InterestLeg.InterestLegBuilder setInterestCalculation(InterestCalculation interestCalculation) {
			this.interestCalculation = interestCalculation==null?null:interestCalculation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("stubCalculationPeriod")
		public InterestLeg.InterestLegBuilder setStubCalculationPeriod(StubCalculationPeriod stubCalculationPeriod) {
			this.stubCalculationPeriod = stubCalculationPeriod==null?null:stubCalculationPeriod.toBuilder();
			return this;
		}
		
		@Override
		public InterestLeg build() {
			return new InterestLeg.InterestLegImpl(this);
		}
		
		@Override
		public InterestLeg.InterestLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestLeg.InterestLegBuilder prune() {
			super.prune();
			if (interestLegCalculationPeriodDates!=null && !interestLegCalculationPeriodDates.prune().hasData()) interestLegCalculationPeriodDates = null;
			if (notional!=null && !notional.prune().hasData()) notional = null;
			if (interestAmount!=null && !interestAmount.prune().hasData()) interestAmount = null;
			if (interestCalculation!=null && !interestCalculation.prune().hasData()) interestCalculation = null;
			if (stubCalculationPeriod!=null && !stubCalculationPeriod.prune().hasData()) stubCalculationPeriod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInterestLegCalculationPeriodDates()!=null && getInterestLegCalculationPeriodDates().hasData()) return true;
			if (getNotional()!=null && getNotional().hasData()) return true;
			if (getInterestAmount()!=null && getInterestAmount().hasData()) return true;
			if (getInterestCalculation()!=null && getInterestCalculation().hasData()) return true;
			if (getStubCalculationPeriod()!=null && getStubCalculationPeriod().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestLeg.InterestLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InterestLeg.InterestLegBuilder o = (InterestLeg.InterestLegBuilder) other;
			
			merger.mergeRosetta(getInterestLegCalculationPeriodDates(), o.getInterestLegCalculationPeriodDates(), this::setInterestLegCalculationPeriodDates);
			merger.mergeRosetta(getNotional(), o.getNotional(), this::setNotional);
			merger.mergeRosetta(getInterestAmount(), o.getInterestAmount(), this::setInterestAmount);
			merger.mergeRosetta(getInterestCalculation(), o.getInterestCalculation(), this::setInterestCalculation);
			merger.mergeRosetta(getStubCalculationPeriod(), o.getStubCalculationPeriod(), this::setStubCalculationPeriod);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestLeg _that = getType().cast(o);
		
			if (!Objects.equals(interestLegCalculationPeriodDates, _that.getInterestLegCalculationPeriodDates())) return false;
			if (!Objects.equals(notional, _that.getNotional())) return false;
			if (!Objects.equals(interestAmount, _that.getInterestAmount())) return false;
			if (!Objects.equals(interestCalculation, _that.getInterestCalculation())) return false;
			if (!Objects.equals(stubCalculationPeriod, _that.getStubCalculationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (interestLegCalculationPeriodDates != null ? interestLegCalculationPeriodDates.hashCode() : 0);
			_result = 31 * _result + (notional != null ? notional.hashCode() : 0);
			_result = 31 * _result + (interestAmount != null ? interestAmount.hashCode() : 0);
			_result = 31 * _result + (interestCalculation != null ? interestCalculation.hashCode() : 0);
			_result = 31 * _result + (stubCalculationPeriod != null ? stubCalculationPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestLegBuilder {" +
				"interestLegCalculationPeriodDates=" + this.interestLegCalculationPeriodDates + ", " +
				"notional=" + this.notional + ", " +
				"interestAmount=" + this.interestAmount + ", " +
				"interestCalculation=" + this.interestCalculation + ", " +
				"stubCalculationPeriod=" + this.stubCalculationPeriod +
			'}' + " " + super.toString();
		}
	}
}
