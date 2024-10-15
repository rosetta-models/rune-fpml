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
import fpml.confirmation.DirectionalLegUnderlyerValuation;
import fpml.confirmation.DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder;
import fpml.confirmation.DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilderImpl;
import fpml.confirmation.DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationImpl;
import fpml.confirmation.EquityValuation;
import fpml.confirmation.FxFeature;
import fpml.confirmation.LegIdentifier;
import fpml.confirmation.OptionSettlementModel;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.Underlyer;
import fpml.confirmation.VolatilityAmount;
import fpml.confirmation.VolatilityLeg;
import fpml.confirmation.VolatilityLeg.VolatilityLegBuilder;
import fpml.confirmation.VolatilityLeg.VolatilityLegBuilderImpl;
import fpml.confirmation.VolatilityLeg.VolatilityLegImpl;
import fpml.confirmation.meta.VolatilityLegMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="VolatilityLeg", builder=VolatilityLeg.VolatilityLegBuilderImpl.class, version="${project.version}")
public interface VolatilityLeg extends DirectionalLegUnderlyerValuation {

	VolatilityLegMeta metaData = new VolatilityLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies, in relation to each Equity Payment Date, the amount to which the Equity Payment Date relates. Unless otherwise specified, this term has the meaning defined in the ISDA 2011 and 2002 Equity Derivatives Definitions.
	 */
	VolatilityAmount getAmount();

	/*********************** Build Methods  ***********************/
	VolatilityLeg build();
	
	VolatilityLeg.VolatilityLegBuilder toBuilder();
	
	static VolatilityLeg.VolatilityLegBuilder builder() {
		return new VolatilityLeg.VolatilityLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VolatilityLeg> getType() {
		return VolatilityLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.class, getLegIdentifier());
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("underlyer"), processor, Underlyer.class, getUnderlyer());
		processRosetta(path.newSubPath("optionSettlementModel"), processor, OptionSettlementModel.class, getOptionSettlementModel());
		processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.class, getFxFeature());
		processRosetta(path.newSubPath("valuation"), processor, EquityValuation.class, getValuation());
		processRosetta(path.newSubPath("amount"), processor, VolatilityAmount.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilityLegBuilder extends VolatilityLeg, DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder {
		VolatilityAmount.VolatilityAmountBuilder getOrCreateAmount();
		VolatilityAmount.VolatilityAmountBuilder getAmount();
		VolatilityLeg.VolatilityLegBuilder setId(String id);
		VolatilityLeg.VolatilityLegBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		VolatilityLeg.VolatilityLegBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		VolatilityLeg.VolatilityLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		VolatilityLeg.VolatilityLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		VolatilityLeg.VolatilityLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		VolatilityLeg.VolatilityLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		VolatilityLeg.VolatilityLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		VolatilityLeg.VolatilityLegBuilder setUnderlyer(Underlyer underlyer);
		VolatilityLeg.VolatilityLegBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel);
		VolatilityLeg.VolatilityLegBuilder setFxFeature(FxFeature fxFeature);
		VolatilityLeg.VolatilityLegBuilder setValuation(EquityValuation valuation);
		VolatilityLeg.VolatilityLegBuilder setAmount(VolatilityAmount amount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("legIdentifier"), processor, LegIdentifier.LegIdentifierBuilder.class, getLegIdentifier());
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("underlyer"), processor, Underlyer.UnderlyerBuilder.class, getUnderlyer());
			processRosetta(path.newSubPath("optionSettlementModel"), processor, OptionSettlementModel.OptionSettlementModelBuilder.class, getOptionSettlementModel());
			processRosetta(path.newSubPath("fxFeature"), processor, FxFeature.FxFeatureBuilder.class, getFxFeature());
			processRosetta(path.newSubPath("valuation"), processor, EquityValuation.EquityValuationBuilder.class, getValuation());
			processRosetta(path.newSubPath("amount"), processor, VolatilityAmount.VolatilityAmountBuilder.class, getAmount());
		}
		

		VolatilityLeg.VolatilityLegBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityLeg  ***********************/
	class VolatilityLegImpl extends DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationImpl implements VolatilityLeg {
		private final VolatilityAmount amount;
		
		protected VolatilityLegImpl(VolatilityLeg.VolatilityLegBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public VolatilityAmount getAmount() {
			return amount;
		}
		
		@Override
		public VolatilityLeg build() {
			return this;
		}
		
		@Override
		public VolatilityLeg.VolatilityLegBuilder toBuilder() {
			VolatilityLeg.VolatilityLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityLeg.VolatilityLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityLeg _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityLeg {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilityLeg  ***********************/
	class VolatilityLegBuilderImpl extends DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilderImpl  implements VolatilityLeg.VolatilityLegBuilder {
	
		protected VolatilityAmount.VolatilityAmountBuilder amount;
	
		public VolatilityLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amount")
		public VolatilityAmount.VolatilityAmountBuilder getAmount() {
			return amount;
		}
		
		@Override
		public VolatilityAmount.VolatilityAmountBuilder getOrCreateAmount() {
			VolatilityAmount.VolatilityAmountBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = VolatilityAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public VolatilityLeg.VolatilityLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public VolatilityLeg.VolatilityLegBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public VolatilityLeg.VolatilityLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public VolatilityLeg.VolatilityLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("legIdentifier")
		public VolatilityLeg.VolatilityLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public VolatilityLeg.VolatilityLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public VolatilityLeg.VolatilityLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public VolatilityLeg.VolatilityLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public VolatilityLeg.VolatilityLegBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionSettlementModel")
		public VolatilityLeg.VolatilityLegBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel) {
			this.optionSettlementModel = optionSettlementModel==null?null:optionSettlementModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxFeature")
		public VolatilityLeg.VolatilityLegBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuation")
		public VolatilityLeg.VolatilityLegBuilder setValuation(EquityValuation valuation) {
			this.valuation = valuation==null?null:valuation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public VolatilityLeg.VolatilityLegBuilder setAmount(VolatilityAmount amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public VolatilityLeg build() {
			return new VolatilityLeg.VolatilityLegImpl(this);
		}
		
		@Override
		public VolatilityLeg.VolatilityLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityLeg.VolatilityLegBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityLeg.VolatilityLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VolatilityLeg.VolatilityLegBuilder o = (VolatilityLeg.VolatilityLegBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityLeg _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityLegBuilder {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
