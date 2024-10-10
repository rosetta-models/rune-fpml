package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.LenderClassification;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.TransferFeeDefinition;
import fpml.confirmation.TransferFeeDefinition.TransferFeeDefinitionBuilder;
import fpml.confirmation.TransferFeeDefinition.TransferFeeDefinitionBuilderImpl;
import fpml.confirmation.TransferFeeDefinition.TransferFeeDefinitionImpl;
import fpml.confirmation.TransferFeeRule;
import fpml.confirmation.meta.TransferFeeDefinitionMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A structure that represents the rules for payment of transfer fees to the agent.
 * @version ${project.version}
 */
@RosettaDataType(value="TransferFeeDefinition", builder=TransferFeeDefinition.TransferFeeDefinitionBuilderImpl.class, version="${project.version}")
public interface TransferFeeDefinition extends RosettaModelObject {

	TransferFeeDefinitionMeta metaData = new TransferFeeDefinitionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount payable to the agent for re-assigning a share in one of the underlying facilities within the deal.
	 */
	NonNegativeMoney getAmount();
	/**
	 * A rule which defines the calculation of transfer fees applicable as a result of a facility commitment transfer.
	 */
	TransferFeeRule getRule();
	/**
	 * The list of lender types which are exempt from paying an transfer fee to the agent bank.
	 */
	List<? extends LenderClassification> getLenderTypeWaived();

	/*********************** Build Methods  ***********************/
	TransferFeeDefinition build();
	
	TransferFeeDefinition.TransferFeeDefinitionBuilder toBuilder();
	
	static TransferFeeDefinition.TransferFeeDefinitionBuilder builder() {
		return new TransferFeeDefinition.TransferFeeDefinitionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TransferFeeDefinition> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TransferFeeDefinition> getType() {
		return TransferFeeDefinition.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.class, getAmount());
		processRosetta(path.newSubPath("rule"), processor, TransferFeeRule.class, getRule());
		processRosetta(path.newSubPath("lenderTypeWaived"), processor, LenderClassification.class, getLenderTypeWaived());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TransferFeeDefinitionBuilder extends TransferFeeDefinition, RosettaModelObjectBuilder {
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getAmount();
		TransferFeeRule.TransferFeeRuleBuilder getOrCreateRule();
		TransferFeeRule.TransferFeeRuleBuilder getRule();
		LenderClassification.LenderClassificationBuilder getOrCreateLenderTypeWaived(int _index);
		List<? extends LenderClassification.LenderClassificationBuilder> getLenderTypeWaived();
		TransferFeeDefinition.TransferFeeDefinitionBuilder setAmount(NonNegativeMoney amount);
		TransferFeeDefinition.TransferFeeDefinitionBuilder setRule(TransferFeeRule rule);
		TransferFeeDefinition.TransferFeeDefinitionBuilder addLenderTypeWaived(LenderClassification lenderTypeWaived0);
		TransferFeeDefinition.TransferFeeDefinitionBuilder addLenderTypeWaived(LenderClassification lenderTypeWaived1, int _idx);
		TransferFeeDefinition.TransferFeeDefinitionBuilder addLenderTypeWaived(List<? extends LenderClassification> lenderTypeWaived2);
		TransferFeeDefinition.TransferFeeDefinitionBuilder setLenderTypeWaived(List<? extends LenderClassification> lenderTypeWaived3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("rule"), processor, TransferFeeRule.TransferFeeRuleBuilder.class, getRule());
			processRosetta(path.newSubPath("lenderTypeWaived"), processor, LenderClassification.LenderClassificationBuilder.class, getLenderTypeWaived());
		}
		

		TransferFeeDefinition.TransferFeeDefinitionBuilder prune();
	}

	/*********************** Immutable Implementation of TransferFeeDefinition  ***********************/
	class TransferFeeDefinitionImpl implements TransferFeeDefinition {
		private final NonNegativeMoney amount;
		private final TransferFeeRule rule;
		private final List<? extends LenderClassification> lenderTypeWaived;
		
		protected TransferFeeDefinitionImpl(TransferFeeDefinition.TransferFeeDefinitionBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.rule = ofNullable(builder.getRule()).map(f->f.build()).orElse(null);
			this.lenderTypeWaived = ofNullable(builder.getLenderTypeWaived()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		public NonNegativeMoney getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("rule")
		public TransferFeeRule getRule() {
			return rule;
		}
		
		@Override
		@RosettaAttribute("lenderTypeWaived")
		public List<? extends LenderClassification> getLenderTypeWaived() {
			return lenderTypeWaived;
		}
		
		@Override
		public TransferFeeDefinition build() {
			return this;
		}
		
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder toBuilder() {
			TransferFeeDefinition.TransferFeeDefinitionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransferFeeDefinition.TransferFeeDefinitionBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getRule()).ifPresent(builder::setRule);
			ofNullable(getLenderTypeWaived()).ifPresent(builder::setLenderTypeWaived);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferFeeDefinition _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(rule, _that.getRule())) return false;
			if (!ListEquals.listEquals(lenderTypeWaived, _that.getLenderTypeWaived())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (rule != null ? rule.hashCode() : 0);
			_result = 31 * _result + (lenderTypeWaived != null ? lenderTypeWaived.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferFeeDefinition {" +
				"amount=" + this.amount + ", " +
				"rule=" + this.rule + ", " +
				"lenderTypeWaived=" + this.lenderTypeWaived +
			'}';
		}
	}

	/*********************** Builder Implementation of TransferFeeDefinition  ***********************/
	class TransferFeeDefinitionBuilderImpl implements TransferFeeDefinition.TransferFeeDefinitionBuilder {
	
		protected NonNegativeMoney.NonNegativeMoneyBuilder amount;
		protected TransferFeeRule.TransferFeeRuleBuilder rule;
		protected List<LenderClassification.LenderClassificationBuilder> lenderTypeWaived = new ArrayList<>();
	
		public TransferFeeDefinitionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("amount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rule")
		public TransferFeeRule.TransferFeeRuleBuilder getRule() {
			return rule;
		}
		
		@Override
		public TransferFeeRule.TransferFeeRuleBuilder getOrCreateRule() {
			TransferFeeRule.TransferFeeRuleBuilder result;
			if (rule!=null) {
				result = rule;
			}
			else {
				result = rule = TransferFeeRule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lenderTypeWaived")
		public List<? extends LenderClassification.LenderClassificationBuilder> getLenderTypeWaived() {
			return lenderTypeWaived;
		}
		
		public LenderClassification.LenderClassificationBuilder getOrCreateLenderTypeWaived(int _index) {
		
			if (lenderTypeWaived==null) {
				this.lenderTypeWaived = new ArrayList<>();
			}
			LenderClassification.LenderClassificationBuilder result;
			return getIndex(lenderTypeWaived, _index, () -> {
						LenderClassification.LenderClassificationBuilder newLenderTypeWaived = LenderClassification.builder();
						return newLenderTypeWaived;
					});
		}
		
		@Override
		@RosettaAttribute("amount")
		public TransferFeeDefinition.TransferFeeDefinitionBuilder setAmount(NonNegativeMoney amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("rule")
		public TransferFeeDefinition.TransferFeeDefinitionBuilder setRule(TransferFeeRule rule) {
			this.rule = rule==null?null:rule.toBuilder();
			return this;
		}
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder addLenderTypeWaived(LenderClassification lenderTypeWaived) {
			if (lenderTypeWaived!=null) this.lenderTypeWaived.add(lenderTypeWaived.toBuilder());
			return this;
		}
		
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder addLenderTypeWaived(LenderClassification lenderTypeWaived, int _idx) {
			getIndex(this.lenderTypeWaived, _idx, () -> lenderTypeWaived.toBuilder());
			return this;
		}
		@Override 
		public TransferFeeDefinition.TransferFeeDefinitionBuilder addLenderTypeWaived(List<? extends LenderClassification> lenderTypeWaiveds) {
			if (lenderTypeWaiveds != null) {
				for (LenderClassification toAdd : lenderTypeWaiveds) {
					this.lenderTypeWaived.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("lenderTypeWaived")
		public TransferFeeDefinition.TransferFeeDefinitionBuilder setLenderTypeWaived(List<? extends LenderClassification> lenderTypeWaiveds) {
			if (lenderTypeWaiveds == null)  {
				this.lenderTypeWaived = new ArrayList<>();
			}
			else {
				this.lenderTypeWaived = lenderTypeWaiveds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public TransferFeeDefinition build() {
			return new TransferFeeDefinition.TransferFeeDefinitionImpl(this);
		}
		
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (rule!=null && !rule.prune().hasData()) rule = null;
			lenderTypeWaived = lenderTypeWaived.stream().filter(b->b!=null).<LenderClassification.LenderClassificationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getRule()!=null && getRule().hasData()) return true;
			if (getLenderTypeWaived()!=null && getLenderTypeWaived().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferFeeDefinition.TransferFeeDefinitionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransferFeeDefinition.TransferFeeDefinitionBuilder o = (TransferFeeDefinition.TransferFeeDefinitionBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getRule(), o.getRule(), this::setRule);
			merger.mergeRosetta(getLenderTypeWaived(), o.getLenderTypeWaived(), this::getOrCreateLenderTypeWaived);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferFeeDefinition _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(rule, _that.getRule())) return false;
			if (!ListEquals.listEquals(lenderTypeWaived, _that.getLenderTypeWaived())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (rule != null ? rule.hashCode() : 0);
			_result = 31 * _result + (lenderTypeWaived != null ? lenderTypeWaived.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferFeeDefinitionBuilder {" +
				"amount=" + this.amount + ", " +
				"rule=" + this.rule + ", " +
				"lenderTypeWaived=" + this.lenderTypeWaived +
			'}';
		}
	}
}
