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
import fpml.confirmation.CorrelationAmount;
import fpml.confirmation.CorrelationLeg;
import fpml.confirmation.CorrelationLeg.CorrelationLegBuilder;
import fpml.confirmation.CorrelationLeg.CorrelationLegBuilderImpl;
import fpml.confirmation.CorrelationLeg.CorrelationLegImpl;
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
import fpml.confirmation.meta.CorrelationLegMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type describing return which is driven by a Correlation calculation.
 * @version ${project.version}
 */
@RosettaDataType(value="CorrelationLeg", builder=CorrelationLeg.CorrelationLegBuilderImpl.class, version="${project.version}")
public interface CorrelationLeg extends DirectionalLegUnderlyerValuation {

	CorrelationLegMeta metaData = new CorrelationLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies, in relation to each Equity Payment Date, the Equity Amount to which the Equity Payment Date relates. Unless otherwise specified, this term has the meaning defined in the ISDA 2002 Equity Derivatives Definitions.
	 */
	CorrelationAmount getAmount();

	/*********************** Build Methods  ***********************/
	CorrelationLeg build();
	
	CorrelationLeg.CorrelationLegBuilder toBuilder();
	
	static CorrelationLeg.CorrelationLegBuilder builder() {
		return new CorrelationLeg.CorrelationLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CorrelationLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CorrelationLeg> getType() {
		return CorrelationLeg.class;
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
		processRosetta(path.newSubPath("amount"), processor, CorrelationAmount.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CorrelationLegBuilder extends CorrelationLeg, DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder {
		CorrelationAmount.CorrelationAmountBuilder getOrCreateAmount();
		CorrelationAmount.CorrelationAmountBuilder getAmount();
		CorrelationLeg.CorrelationLegBuilder setId(String id);
		CorrelationLeg.CorrelationLegBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		CorrelationLeg.CorrelationLegBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		CorrelationLeg.CorrelationLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		CorrelationLeg.CorrelationLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		CorrelationLeg.CorrelationLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		CorrelationLeg.CorrelationLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CorrelationLeg.CorrelationLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		CorrelationLeg.CorrelationLegBuilder setUnderlyer(Underlyer underlyer);
		CorrelationLeg.CorrelationLegBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel);
		CorrelationLeg.CorrelationLegBuilder setFxFeature(FxFeature fxFeature);
		CorrelationLeg.CorrelationLegBuilder setValuation(EquityValuation valuation);
		CorrelationLeg.CorrelationLegBuilder setAmount(CorrelationAmount amount);

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
			processRosetta(path.newSubPath("amount"), processor, CorrelationAmount.CorrelationAmountBuilder.class, getAmount());
		}
		

		CorrelationLeg.CorrelationLegBuilder prune();
	}

	/*********************** Immutable Implementation of CorrelationLeg  ***********************/
	class CorrelationLegImpl extends DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationImpl implements CorrelationLeg {
		private final CorrelationAmount amount;
		
		protected CorrelationLegImpl(CorrelationLeg.CorrelationLegBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public CorrelationAmount getAmount() {
			return amount;
		}
		
		@Override
		public CorrelationLeg build() {
			return this;
		}
		
		@Override
		public CorrelationLeg.CorrelationLegBuilder toBuilder() {
			CorrelationLeg.CorrelationLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CorrelationLeg.CorrelationLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationLeg _that = getType().cast(o);
		
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
			return "CorrelationLeg {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CorrelationLeg  ***********************/
	class CorrelationLegBuilderImpl extends DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilderImpl  implements CorrelationLeg.CorrelationLegBuilder {
	
		protected CorrelationAmount.CorrelationAmountBuilder amount;
	
		public CorrelationLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amount")
		public CorrelationAmount.CorrelationAmountBuilder getAmount() {
			return amount;
		}
		
		@Override
		public CorrelationAmount.CorrelationAmountBuilder getOrCreateAmount() {
			CorrelationAmount.CorrelationAmountBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = CorrelationAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public CorrelationLeg.CorrelationLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public CorrelationLeg.CorrelationLegBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public CorrelationLeg.CorrelationLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public CorrelationLeg.CorrelationLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("legIdentifier")
		public CorrelationLeg.CorrelationLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public CorrelationLeg.CorrelationLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public CorrelationLeg.CorrelationLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public CorrelationLeg.CorrelationLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public CorrelationLeg.CorrelationLegBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionSettlementModel")
		public CorrelationLeg.CorrelationLegBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel) {
			this.optionSettlementModel = optionSettlementModel==null?null:optionSettlementModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxFeature")
		public CorrelationLeg.CorrelationLegBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuation")
		public CorrelationLeg.CorrelationLegBuilder setValuation(EquityValuation valuation) {
			this.valuation = valuation==null?null:valuation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public CorrelationLeg.CorrelationLegBuilder setAmount(CorrelationAmount amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public CorrelationLeg build() {
			return new CorrelationLeg.CorrelationLegImpl(this);
		}
		
		@Override
		public CorrelationLeg.CorrelationLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CorrelationLeg.CorrelationLegBuilder prune() {
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
		public CorrelationLeg.CorrelationLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CorrelationLeg.CorrelationLegBuilder o = (CorrelationLeg.CorrelationLegBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CorrelationLeg _that = getType().cast(o);
		
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
			return "CorrelationLegBuilder {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
