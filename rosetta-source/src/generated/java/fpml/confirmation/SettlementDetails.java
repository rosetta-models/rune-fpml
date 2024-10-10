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
import fpml.confirmation.Currency;
import fpml.confirmation.SettlementDetails;
import fpml.confirmation.SettlementDetails.SettlementDetailsBuilder;
import fpml.confirmation.SettlementDetails.SettlementDetailsBuilderImpl;
import fpml.confirmation.SettlementDetails.SettlementDetailsImpl;
import fpml.confirmation.SettlementInstruction;
import fpml.confirmation.SettlementInstructionId;
import fpml.confirmation.meta.SettlementDetailsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A set of currency-specific settlement instructions.
 * @version ${project.version}
 */
@RosettaDataType(value="SettlementDetails", builder=SettlementDetails.SettlementDetailsBuilderImpl.class, version="${project.version}")
public interface SettlementDetails extends RosettaModelObject {

	SettlementDetailsMeta metaData = new SettlementDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique identifier for a cash settlement details structure.
	 */
	SettlementInstructionId getId();
	/**
	 * Currency associated with the settlement instruction.
	 */
	Currency getCurrency();
	/**
	 * A standard settlement instruction defining how a currency payment is to be made.
	 */
	SettlementInstruction getSettlementInstruction();

	/*********************** Build Methods  ***********************/
	SettlementDetails build();
	
	SettlementDetails.SettlementDetailsBuilder toBuilder();
	
	static SettlementDetails.SettlementDetailsBuilder builder() {
		return new SettlementDetails.SettlementDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SettlementDetails> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends SettlementDetails> getType() {
		return SettlementDetails.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("id"), processor, SettlementInstructionId.class, getId());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("settlementInstruction"), processor, SettlementInstruction.class, getSettlementInstruction());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SettlementDetailsBuilder extends SettlementDetails, RosettaModelObjectBuilder {
		SettlementInstructionId.SettlementInstructionIdBuilder getOrCreateId();
		SettlementInstructionId.SettlementInstructionIdBuilder getId();
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		SettlementInstruction.SettlementInstructionBuilder getOrCreateSettlementInstruction();
		SettlementInstruction.SettlementInstructionBuilder getSettlementInstruction();
		SettlementDetails.SettlementDetailsBuilder setId(SettlementInstructionId id);
		SettlementDetails.SettlementDetailsBuilder setCurrency(Currency currency);
		SettlementDetails.SettlementDetailsBuilder setSettlementInstruction(SettlementInstruction settlementInstruction);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("id"), processor, SettlementInstructionId.SettlementInstructionIdBuilder.class, getId());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("settlementInstruction"), processor, SettlementInstruction.SettlementInstructionBuilder.class, getSettlementInstruction());
		}
		

		SettlementDetails.SettlementDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of SettlementDetails  ***********************/
	class SettlementDetailsImpl implements SettlementDetails {
		private final SettlementInstructionId id;
		private final Currency currency;
		private final SettlementInstruction settlementInstruction;
		
		protected SettlementDetailsImpl(SettlementDetails.SettlementDetailsBuilder builder) {
			this.id = ofNullable(builder.getId()).map(f->f.build()).orElse(null);
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.settlementInstruction = ofNullable(builder.getSettlementInstruction()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		public SettlementInstructionId getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("settlementInstruction")
		public SettlementInstruction getSettlementInstruction() {
			return settlementInstruction;
		}
		
		@Override
		public SettlementDetails build() {
			return this;
		}
		
		@Override
		public SettlementDetails.SettlementDetailsBuilder toBuilder() {
			SettlementDetails.SettlementDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementDetails.SettlementDetailsBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getSettlementInstruction()).ifPresent(builder::setSettlementInstruction);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementDetails _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(settlementInstruction, _that.getSettlementInstruction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (settlementInstruction != null ? settlementInstruction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementDetails {" +
				"id=" + this.id + ", " +
				"currency=" + this.currency + ", " +
				"settlementInstruction=" + this.settlementInstruction +
			'}';
		}
	}

	/*********************** Builder Implementation of SettlementDetails  ***********************/
	class SettlementDetailsBuilderImpl implements SettlementDetails.SettlementDetailsBuilder {
	
		protected SettlementInstructionId.SettlementInstructionIdBuilder id;
		protected Currency.CurrencyBuilder currency;
		protected SettlementInstruction.SettlementInstructionBuilder settlementInstruction;
	
		public SettlementDetailsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public SettlementInstructionId.SettlementInstructionIdBuilder getId() {
			return id;
		}
		
		@Override
		public SettlementInstructionId.SettlementInstructionIdBuilder getOrCreateId() {
			SettlementInstructionId.SettlementInstructionIdBuilder result;
			if (id!=null) {
				result = id;
			}
			else {
				result = id = SettlementInstructionId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency.CurrencyBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency() {
			Currency.CurrencyBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = Currency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementInstruction")
		public SettlementInstruction.SettlementInstructionBuilder getSettlementInstruction() {
			return settlementInstruction;
		}
		
		@Override
		public SettlementInstruction.SettlementInstructionBuilder getOrCreateSettlementInstruction() {
			SettlementInstruction.SettlementInstructionBuilder result;
			if (settlementInstruction!=null) {
				result = settlementInstruction;
			}
			else {
				result = settlementInstruction = SettlementInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public SettlementDetails.SettlementDetailsBuilder setId(SettlementInstructionId id) {
			this.id = id==null?null:id.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public SettlementDetails.SettlementDetailsBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementInstruction")
		public SettlementDetails.SettlementDetailsBuilder setSettlementInstruction(SettlementInstruction settlementInstruction) {
			this.settlementInstruction = settlementInstruction==null?null:settlementInstruction.toBuilder();
			return this;
		}
		
		@Override
		public SettlementDetails build() {
			return new SettlementDetails.SettlementDetailsImpl(this);
		}
		
		@Override
		public SettlementDetails.SettlementDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementDetails.SettlementDetailsBuilder prune() {
			if (id!=null && !id.prune().hasData()) id = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (settlementInstruction!=null && !settlementInstruction.prune().hasData()) settlementInstruction = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null && getId().hasData()) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getSettlementInstruction()!=null && getSettlementInstruction().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementDetails.SettlementDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettlementDetails.SettlementDetailsBuilder o = (SettlementDetails.SettlementDetailsBuilder) other;
			
			merger.mergeRosetta(getId(), o.getId(), this::setId);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getSettlementInstruction(), o.getSettlementInstruction(), this::setSettlementInstruction);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettlementDetails _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(settlementInstruction, _that.getSettlementInstruction())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (settlementInstruction != null ? settlementInstruction.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementDetailsBuilder {" +
				"id=" + this.id + ", " +
				"currency=" + this.currency + ", " +
				"settlementInstruction=" + this.settlementInstruction +
			'}';
		}
	}
}
