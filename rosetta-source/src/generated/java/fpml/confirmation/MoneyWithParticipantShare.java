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
import fpml.confirmation.Money;
import fpml.confirmation.Money.MoneyBuilder;
import fpml.confirmation.Money.MoneyBuilderImpl;
import fpml.confirmation.Money.MoneyImpl;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.MoneyWithParticipantShare.MoneyWithParticipantShareBuilder;
import fpml.confirmation.MoneyWithParticipantShare.MoneyWithParticipantShareBuilderImpl;
import fpml.confirmation.MoneyWithParticipantShare.MoneyWithParticipantShareImpl;
import fpml.confirmation.meta.MoneyWithParticipantShareMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An extension of the money type with the ability to specify a lender share amount in addition to the global amount (represented by &#39;amount&#39;).
 * @version ${project.version}
 */
@RosettaDataType(value="MoneyWithParticipantShare", builder=MoneyWithParticipantShare.MoneyWithParticipantShareBuilderImpl.class, version="${project.version}")
public interface MoneyWithParticipantShare extends Money {

	MoneyWithParticipantShareMeta metaData = new MoneyWithParticipantShareMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The lender share amount.
	 */
	BigDecimal getShareAmount();

	/*********************** Build Methods  ***********************/
	MoneyWithParticipantShare build();
	
	MoneyWithParticipantShare.MoneyWithParticipantShareBuilder toBuilder();
	
	static MoneyWithParticipantShare.MoneyWithParticipantShareBuilder builder() {
		return new MoneyWithParticipantShare.MoneyWithParticipantShareBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MoneyWithParticipantShare> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MoneyWithParticipantShare> getType() {
		return MoneyWithParticipantShare.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("shareAmount"), BigDecimal.class, getShareAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MoneyWithParticipantShareBuilder extends MoneyWithParticipantShare, Money.MoneyBuilder {
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setCurrency(Currency currency);
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setId(String id);
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setAmount(BigDecimal amount);
		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setShareAmount(BigDecimal shareAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("shareAmount"), BigDecimal.class, getShareAmount(), this);
		}
		

		MoneyWithParticipantShare.MoneyWithParticipantShareBuilder prune();
	}

	/*********************** Immutable Implementation of MoneyWithParticipantShare  ***********************/
	class MoneyWithParticipantShareImpl extends Money.MoneyImpl implements MoneyWithParticipantShare {
		private final BigDecimal shareAmount;
		
		protected MoneyWithParticipantShareImpl(MoneyWithParticipantShare.MoneyWithParticipantShareBuilder builder) {
			super(builder);
			this.shareAmount = builder.getShareAmount();
		}
		
		@Override
		@RosettaAttribute("shareAmount")
		public BigDecimal getShareAmount() {
			return shareAmount;
		}
		
		@Override
		public MoneyWithParticipantShare build() {
			return this;
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder toBuilder() {
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MoneyWithParticipantShare.MoneyWithParticipantShareBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getShareAmount()).ifPresent(builder::setShareAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MoneyWithParticipantShare _that = getType().cast(o);
		
			if (!Objects.equals(shareAmount, _that.getShareAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (shareAmount != null ? shareAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyWithParticipantShare {" +
				"shareAmount=" + this.shareAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of MoneyWithParticipantShare  ***********************/
	class MoneyWithParticipantShareBuilderImpl extends Money.MoneyBuilderImpl  implements MoneyWithParticipantShare.MoneyWithParticipantShareBuilder {
	
		protected BigDecimal shareAmount;
	
		public MoneyWithParticipantShareBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("shareAmount")
		public BigDecimal getShareAmount() {
			return shareAmount;
		}
		
		@Override
		@RosettaAttribute("currency")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("amount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		@RosettaAttribute("shareAmount")
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder setShareAmount(BigDecimal shareAmount) {
			this.shareAmount = shareAmount==null?null:shareAmount;
			return this;
		}
		
		@Override
		public MoneyWithParticipantShare build() {
			return new MoneyWithParticipantShare.MoneyWithParticipantShareImpl(this);
		}
		
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getShareAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MoneyWithParticipantShare.MoneyWithParticipantShareBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			MoneyWithParticipantShare.MoneyWithParticipantShareBuilder o = (MoneyWithParticipantShare.MoneyWithParticipantShareBuilder) other;
			
			
			merger.mergeBasic(getShareAmount(), o.getShareAmount(), this::setShareAmount);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			MoneyWithParticipantShare _that = getType().cast(o);
		
			if (!Objects.equals(shareAmount, _that.getShareAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (shareAmount != null ? shareAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MoneyWithParticipantShareBuilder {" +
				"shareAmount=" + this.shareAmount +
			'}' + " " + super.toString();
		}
	}
}
