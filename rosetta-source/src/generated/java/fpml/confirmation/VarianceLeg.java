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
import fpml.confirmation.VarianceAmount;
import fpml.confirmation.VarianceLeg;
import fpml.confirmation.VarianceLeg.VarianceLegBuilder;
import fpml.confirmation.VarianceLeg.VarianceLegBuilderImpl;
import fpml.confirmation.VarianceLeg.VarianceLegImpl;
import fpml.confirmation.meta.VarianceLegMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type describing return which is driven by a Variance Calculation.
 * @version ${project.version}
 */
@RosettaDataType(value="VarianceLeg", builder=VarianceLeg.VarianceLegBuilderImpl.class, version="${project.version}")
public interface VarianceLeg extends DirectionalLegUnderlyerValuation {

	VarianceLegMeta metaData = new VarianceLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies, in relation to each Equity Payment Date, the amount to which the Equity Payment Date relates. Unless otherwise specified, this term has the meaning defined in the ISDA 2002 Equity Derivatives Definitions.
	 */
	VarianceAmount getAmount();

	/*********************** Build Methods  ***********************/
	VarianceLeg build();
	
	VarianceLeg.VarianceLegBuilder toBuilder();
	
	static VarianceLeg.VarianceLegBuilder builder() {
		return new VarianceLeg.VarianceLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VarianceLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VarianceLeg> getType() {
		return VarianceLeg.class;
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
		processRosetta(path.newSubPath("amount"), processor, VarianceAmount.class, getAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VarianceLegBuilder extends VarianceLeg, DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder {
		VarianceAmount.VarianceAmountBuilder getOrCreateAmount();
		VarianceAmount.VarianceAmountBuilder getAmount();
		VarianceLeg.VarianceLegBuilder setId(String id);
		VarianceLeg.VarianceLegBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		VarianceLeg.VarianceLegBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		VarianceLeg.VarianceLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		VarianceLeg.VarianceLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		VarianceLeg.VarianceLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		VarianceLeg.VarianceLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		VarianceLeg.VarianceLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		VarianceLeg.VarianceLegBuilder setUnderlyer(Underlyer underlyer);
		VarianceLeg.VarianceLegBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel);
		VarianceLeg.VarianceLegBuilder setFxFeature(FxFeature fxFeature);
		VarianceLeg.VarianceLegBuilder setValuation(EquityValuation valuation);
		VarianceLeg.VarianceLegBuilder setAmount(VarianceAmount amount);

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
			processRosetta(path.newSubPath("amount"), processor, VarianceAmount.VarianceAmountBuilder.class, getAmount());
		}
		

		VarianceLeg.VarianceLegBuilder prune();
	}

	/*********************** Immutable Implementation of VarianceLeg  ***********************/
	class VarianceLegImpl extends DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationImpl implements VarianceLeg {
		private final VarianceAmount amount;
		
		protected VarianceLegImpl(VarianceLeg.VarianceLegBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public VarianceAmount getAmount() {
			return amount;
		}
		
		@Override
		public VarianceLeg build() {
			return this;
		}
		
		@Override
		public VarianceLeg.VarianceLegBuilder toBuilder() {
			VarianceLeg.VarianceLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VarianceLeg.VarianceLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceLeg _that = getType().cast(o);
		
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
			return "VarianceLeg {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VarianceLeg  ***********************/
	class VarianceLegBuilderImpl extends DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilderImpl  implements VarianceLeg.VarianceLegBuilder {
	
		protected VarianceAmount.VarianceAmountBuilder amount;
	
		public VarianceLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amount")
		public VarianceAmount.VarianceAmountBuilder getAmount() {
			return amount;
		}
		
		@Override
		public VarianceAmount.VarianceAmountBuilder getOrCreateAmount() {
			VarianceAmount.VarianceAmountBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = VarianceAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public VarianceLeg.VarianceLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public VarianceLeg.VarianceLegBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public VarianceLeg.VarianceLegBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public VarianceLeg.VarianceLegBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("legIdentifier")
		public VarianceLeg.VarianceLegBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public VarianceLeg.VarianceLegBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public VarianceLeg.VarianceLegBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public VarianceLeg.VarianceLegBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public VarianceLeg.VarianceLegBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionSettlementModel")
		public VarianceLeg.VarianceLegBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel) {
			this.optionSettlementModel = optionSettlementModel==null?null:optionSettlementModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxFeature")
		public VarianceLeg.VarianceLegBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuation")
		public VarianceLeg.VarianceLegBuilder setValuation(EquityValuation valuation) {
			this.valuation = valuation==null?null:valuation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public VarianceLeg.VarianceLegBuilder setAmount(VarianceAmount amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		
		@Override
		public VarianceLeg build() {
			return new VarianceLeg.VarianceLegImpl(this);
		}
		
		@Override
		public VarianceLeg.VarianceLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceLeg.VarianceLegBuilder prune() {
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
		public VarianceLeg.VarianceLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VarianceLeg.VarianceLegBuilder o = (VarianceLeg.VarianceLegBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceLeg _that = getType().cast(o);
		
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
			return "VarianceLegBuilder {" +
				"amount=" + this.amount +
			'}' + " " + super.toString();
		}
	}
}
