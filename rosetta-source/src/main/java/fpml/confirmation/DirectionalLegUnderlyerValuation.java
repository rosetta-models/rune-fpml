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
import fpml.confirmation.DirectionalLegUnderlyer;
import fpml.confirmation.DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder;
import fpml.confirmation.DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilderImpl;
import fpml.confirmation.DirectionalLegUnderlyer.DirectionalLegUnderlyerImpl;
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
import fpml.confirmation.meta.DirectionalLegUnderlyerValuationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An abstract base class for all directional leg types with effective date, termination date, and underlyer, where a payer makes a stream of payments of greater than zero value to a receiver.
 * @version ${project.version}
 */
@RosettaDataType(value="DirectionalLegUnderlyerValuation", builder=DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilderImpl.class, version="${project.version}")
public interface DirectionalLegUnderlyerValuation extends DirectionalLegUnderlyer {

	DirectionalLegUnderlyerValuationMeta metaData = new DirectionalLegUnderlyerValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Valuation of the underlyer.
	 */
	EquityValuation getValuation();

	/*********************** Build Methods  ***********************/
	DirectionalLegUnderlyerValuation build();
	
	DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder toBuilder();
	
	static DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder builder() {
		return new DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DirectionalLegUnderlyerValuation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DirectionalLegUnderlyerValuation> getType() {
		return DirectionalLegUnderlyerValuation.class;
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
	}
	

	/*********************** Builder Interface  ***********************/
	interface DirectionalLegUnderlyerValuationBuilder extends DirectionalLegUnderlyerValuation, DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilder {
		EquityValuation.EquityValuationBuilder getOrCreateValuation();
		EquityValuation.EquityValuationBuilder getValuation();
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setId(String id);
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder addLegIdentifier(LegIdentifier legIdentifier0);
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder addLegIdentifier(LegIdentifier legIdentifier1, int _idx);
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifier2);
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifier3);
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setUnderlyer(Underlyer underlyer);
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel);
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setFxFeature(FxFeature fxFeature);
		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setValuation(EquityValuation valuation);

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
		}
		

		DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder prune();
	}

	/*********************** Immutable Implementation of DirectionalLegUnderlyerValuation  ***********************/
	class DirectionalLegUnderlyerValuationImpl extends DirectionalLegUnderlyer.DirectionalLegUnderlyerImpl implements DirectionalLegUnderlyerValuation {
		private final EquityValuation valuation;
		
		protected DirectionalLegUnderlyerValuationImpl(DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder builder) {
			super(builder);
			this.valuation = ofNullable(builder.getValuation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("valuation")
		public EquityValuation getValuation() {
			return valuation;
		}
		
		@Override
		public DirectionalLegUnderlyerValuation build() {
			return this;
		}
		
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder toBuilder() {
			DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getValuation()).ifPresent(builder::setValuation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DirectionalLegUnderlyerValuation _that = getType().cast(o);
		
			if (!Objects.equals(valuation, _that.getValuation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valuation != null ? valuation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DirectionalLegUnderlyerValuation {" +
				"valuation=" + this.valuation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DirectionalLegUnderlyerValuation  ***********************/
	class DirectionalLegUnderlyerValuationBuilderImpl extends DirectionalLegUnderlyer.DirectionalLegUnderlyerBuilderImpl  implements DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder {
	
		protected EquityValuation.EquityValuationBuilder valuation;
	
		public DirectionalLegUnderlyerValuationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("valuation")
		public EquityValuation.EquityValuationBuilder getValuation() {
			return valuation;
		}
		
		@Override
		public EquityValuation.EquityValuationBuilder getOrCreateValuation() {
			EquityValuation.EquityValuationBuilder result;
			if (valuation!=null) {
				result = valuation;
			}
			else {
				result = valuation = EquityValuation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("legIdentifier")
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder addLegIdentifier(LegIdentifier legIdentifier) {
			if (legIdentifier!=null) this.legIdentifier.add(legIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder addLegIdentifier(LegIdentifier legIdentifier, int _idx) {
			getIndex(this.legIdentifier, _idx, () -> legIdentifier.toBuilder());
			return this;
		}
		@Override 
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder addLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
			if (legIdentifiers != null) {
				for (LegIdentifier toAdd : legIdentifiers) {
					this.legIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setLegIdentifier(List<? extends LegIdentifier> legIdentifiers) {
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
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("effectiveDate")
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyer")
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setUnderlyer(Underlyer underlyer) {
			this.underlyer = underlyer==null?null:underlyer.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionSettlementModel")
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setOptionSettlementModel(OptionSettlementModel optionSettlementModel) {
			this.optionSettlementModel = optionSettlementModel==null?null:optionSettlementModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxFeature")
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setFxFeature(FxFeature fxFeature) {
			this.fxFeature = fxFeature==null?null:fxFeature.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("valuation")
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder setValuation(EquityValuation valuation) {
			this.valuation = valuation==null?null:valuation.toBuilder();
			return this;
		}
		
		@Override
		public DirectionalLegUnderlyerValuation build() {
			return new DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationImpl(this);
		}
		
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder prune() {
			super.prune();
			if (valuation!=null && !valuation.prune().hasData()) valuation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getValuation()!=null && getValuation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder o = (DirectionalLegUnderlyerValuation.DirectionalLegUnderlyerValuationBuilder) other;
			
			merger.mergeRosetta(getValuation(), o.getValuation(), this::setValuation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DirectionalLegUnderlyerValuation _that = getType().cast(o);
		
			if (!Objects.equals(valuation, _that.getValuation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (valuation != null ? valuation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DirectionalLegUnderlyerValuationBuilder {" +
				"valuation=" + this.valuation +
			'}' + " " + super.toString();
		}
	}
}
