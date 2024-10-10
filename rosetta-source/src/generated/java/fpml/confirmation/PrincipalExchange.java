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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.Money;
import fpml.confirmation.PrincipalExchange;
import fpml.confirmation.PrincipalExchange.PrincipalExchangeBuilder;
import fpml.confirmation.PrincipalExchange.PrincipalExchangeBuilderImpl;
import fpml.confirmation.PrincipalExchange.PrincipalExchangeImpl;
import fpml.confirmation.meta.PrincipalExchangeMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a principal exchange amount and adjusted exchange date. The type forms part of the cashflow representation of a swap stream.
 * @version ${project.version}
 */
@RosettaDataType(value="PrincipalExchange", builder=PrincipalExchange.PrincipalExchangeBuilderImpl.class, version="${project.version}")
public interface PrincipalExchange extends RosettaModelObject {

	PrincipalExchangeMeta metaData = new PrincipalExchangeMeta();

	/*********************** Getter Methods  ***********************/
	Date getUnadjustedPrincipalExchangeDate();
	/**
	 * The principal exchange date. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedPrincipalExchangeDate();
	/**
	 * The principal exchange amount. This amount should be positive if the stream payer is paying the exchange amount and signed negative if they are receiving it.
	 */
	BigDecimal getPrincipalExchangeAmount();
	/**
	 * The value representing the discount factor used to calculate the present value of the principal exchange amount.
	 */
	BigDecimal getDiscountFactor();
	/**
	 * The amount representing the present value of the principal exchange.
	 */
	Money getPresentValuePrincipalExchangeAmount();
	String getId();

	/*********************** Build Methods  ***********************/
	PrincipalExchange build();
	
	PrincipalExchange.PrincipalExchangeBuilder toBuilder();
	
	static PrincipalExchange.PrincipalExchangeBuilder builder() {
		return new PrincipalExchange.PrincipalExchangeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PrincipalExchange> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PrincipalExchange> getType() {
		return PrincipalExchange.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("unadjustedPrincipalExchangeDate"), Date.class, getUnadjustedPrincipalExchangeDate(), this);
		processor.processBasic(path.newSubPath("adjustedPrincipalExchangeDate"), Date.class, getAdjustedPrincipalExchangeDate(), this);
		processor.processBasic(path.newSubPath("principalExchangeAmount"), BigDecimal.class, getPrincipalExchangeAmount(), this);
		processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
		processRosetta(path.newSubPath("presentValuePrincipalExchangeAmount"), processor, Money.class, getPresentValuePrincipalExchangeAmount());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PrincipalExchangeBuilder extends PrincipalExchange, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreatePresentValuePrincipalExchangeAmount();
		Money.MoneyBuilder getPresentValuePrincipalExchangeAmount();
		PrincipalExchange.PrincipalExchangeBuilder setUnadjustedPrincipalExchangeDate(Date unadjustedPrincipalExchangeDate);
		PrincipalExchange.PrincipalExchangeBuilder setAdjustedPrincipalExchangeDate(Date adjustedPrincipalExchangeDate);
		PrincipalExchange.PrincipalExchangeBuilder setPrincipalExchangeAmount(BigDecimal principalExchangeAmount);
		PrincipalExchange.PrincipalExchangeBuilder setDiscountFactor(BigDecimal discountFactor);
		PrincipalExchange.PrincipalExchangeBuilder setPresentValuePrincipalExchangeAmount(Money presentValuePrincipalExchangeAmount);
		PrincipalExchange.PrincipalExchangeBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("unadjustedPrincipalExchangeDate"), Date.class, getUnadjustedPrincipalExchangeDate(), this);
			processor.processBasic(path.newSubPath("adjustedPrincipalExchangeDate"), Date.class, getAdjustedPrincipalExchangeDate(), this);
			processor.processBasic(path.newSubPath("principalExchangeAmount"), BigDecimal.class, getPrincipalExchangeAmount(), this);
			processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
			processRosetta(path.newSubPath("presentValuePrincipalExchangeAmount"), processor, Money.MoneyBuilder.class, getPresentValuePrincipalExchangeAmount());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		PrincipalExchange.PrincipalExchangeBuilder prune();
	}

	/*********************** Immutable Implementation of PrincipalExchange  ***********************/
	class PrincipalExchangeImpl implements PrincipalExchange {
		private final Date unadjustedPrincipalExchangeDate;
		private final Date adjustedPrincipalExchangeDate;
		private final BigDecimal principalExchangeAmount;
		private final BigDecimal discountFactor;
		private final Money presentValuePrincipalExchangeAmount;
		private final String id;
		
		protected PrincipalExchangeImpl(PrincipalExchange.PrincipalExchangeBuilder builder) {
			this.unadjustedPrincipalExchangeDate = builder.getUnadjustedPrincipalExchangeDate();
			this.adjustedPrincipalExchangeDate = builder.getAdjustedPrincipalExchangeDate();
			this.principalExchangeAmount = builder.getPrincipalExchangeAmount();
			this.discountFactor = builder.getDiscountFactor();
			this.presentValuePrincipalExchangeAmount = ofNullable(builder.getPresentValuePrincipalExchangeAmount()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("unadjustedPrincipalExchangeDate")
		public Date getUnadjustedPrincipalExchangeDate() {
			return unadjustedPrincipalExchangeDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPrincipalExchangeDate")
		public Date getAdjustedPrincipalExchangeDate() {
			return adjustedPrincipalExchangeDate;
		}
		
		@Override
		@RosettaAttribute("principalExchangeAmount")
		public BigDecimal getPrincipalExchangeAmount() {
			return principalExchangeAmount;
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("presentValuePrincipalExchangeAmount")
		public Money getPresentValuePrincipalExchangeAmount() {
			return presentValuePrincipalExchangeAmount;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public PrincipalExchange build() {
			return this;
		}
		
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder toBuilder() {
			PrincipalExchange.PrincipalExchangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalExchange.PrincipalExchangeBuilder builder) {
			ofNullable(getUnadjustedPrincipalExchangeDate()).ifPresent(builder::setUnadjustedPrincipalExchangeDate);
			ofNullable(getAdjustedPrincipalExchangeDate()).ifPresent(builder::setAdjustedPrincipalExchangeDate);
			ofNullable(getPrincipalExchangeAmount()).ifPresent(builder::setPrincipalExchangeAmount);
			ofNullable(getDiscountFactor()).ifPresent(builder::setDiscountFactor);
			ofNullable(getPresentValuePrincipalExchangeAmount()).ifPresent(builder::setPresentValuePrincipalExchangeAmount);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchange _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedPrincipalExchangeDate, _that.getUnadjustedPrincipalExchangeDate())) return false;
			if (!Objects.equals(adjustedPrincipalExchangeDate, _that.getAdjustedPrincipalExchangeDate())) return false;
			if (!Objects.equals(principalExchangeAmount, _that.getPrincipalExchangeAmount())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(presentValuePrincipalExchangeAmount, _that.getPresentValuePrincipalExchangeAmount())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedPrincipalExchangeDate != null ? unadjustedPrincipalExchangeDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPrincipalExchangeDate != null ? adjustedPrincipalExchangeDate.hashCode() : 0);
			_result = 31 * _result + (principalExchangeAmount != null ? principalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (presentValuePrincipalExchangeAmount != null ? presentValuePrincipalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchange {" +
				"unadjustedPrincipalExchangeDate=" + this.unadjustedPrincipalExchangeDate + ", " +
				"adjustedPrincipalExchangeDate=" + this.adjustedPrincipalExchangeDate + ", " +
				"principalExchangeAmount=" + this.principalExchangeAmount + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"presentValuePrincipalExchangeAmount=" + this.presentValuePrincipalExchangeAmount + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of PrincipalExchange  ***********************/
	class PrincipalExchangeBuilderImpl implements PrincipalExchange.PrincipalExchangeBuilder {
	
		protected Date unadjustedPrincipalExchangeDate;
		protected Date adjustedPrincipalExchangeDate;
		protected BigDecimal principalExchangeAmount;
		protected BigDecimal discountFactor;
		protected Money.MoneyBuilder presentValuePrincipalExchangeAmount;
		protected String id;
	
		public PrincipalExchangeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("unadjustedPrincipalExchangeDate")
		public Date getUnadjustedPrincipalExchangeDate() {
			return unadjustedPrincipalExchangeDate;
		}
		
		@Override
		@RosettaAttribute("adjustedPrincipalExchangeDate")
		public Date getAdjustedPrincipalExchangeDate() {
			return adjustedPrincipalExchangeDate;
		}
		
		@Override
		@RosettaAttribute("principalExchangeAmount")
		public BigDecimal getPrincipalExchangeAmount() {
			return principalExchangeAmount;
		}
		
		@Override
		@RosettaAttribute("discountFactor")
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		@RosettaAttribute("presentValuePrincipalExchangeAmount")
		public Money.MoneyBuilder getPresentValuePrincipalExchangeAmount() {
			return presentValuePrincipalExchangeAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePresentValuePrincipalExchangeAmount() {
			Money.MoneyBuilder result;
			if (presentValuePrincipalExchangeAmount!=null) {
				result = presentValuePrincipalExchangeAmount;
			}
			else {
				result = presentValuePrincipalExchangeAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("unadjustedPrincipalExchangeDate")
		public PrincipalExchange.PrincipalExchangeBuilder setUnadjustedPrincipalExchangeDate(Date unadjustedPrincipalExchangeDate) {
			this.unadjustedPrincipalExchangeDate = unadjustedPrincipalExchangeDate==null?null:unadjustedPrincipalExchangeDate;
			return this;
		}
		@Override
		@RosettaAttribute("adjustedPrincipalExchangeDate")
		public PrincipalExchange.PrincipalExchangeBuilder setAdjustedPrincipalExchangeDate(Date adjustedPrincipalExchangeDate) {
			this.adjustedPrincipalExchangeDate = adjustedPrincipalExchangeDate==null?null:adjustedPrincipalExchangeDate;
			return this;
		}
		@Override
		@RosettaAttribute("principalExchangeAmount")
		public PrincipalExchange.PrincipalExchangeBuilder setPrincipalExchangeAmount(BigDecimal principalExchangeAmount) {
			this.principalExchangeAmount = principalExchangeAmount==null?null:principalExchangeAmount;
			return this;
		}
		@Override
		@RosettaAttribute("discountFactor")
		public PrincipalExchange.PrincipalExchangeBuilder setDiscountFactor(BigDecimal discountFactor) {
			this.discountFactor = discountFactor==null?null:discountFactor;
			return this;
		}
		@Override
		@RosettaAttribute("presentValuePrincipalExchangeAmount")
		public PrincipalExchange.PrincipalExchangeBuilder setPresentValuePrincipalExchangeAmount(Money presentValuePrincipalExchangeAmount) {
			this.presentValuePrincipalExchangeAmount = presentValuePrincipalExchangeAmount==null?null:presentValuePrincipalExchangeAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public PrincipalExchange.PrincipalExchangeBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public PrincipalExchange build() {
			return new PrincipalExchange.PrincipalExchangeImpl(this);
		}
		
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder prune() {
			if (presentValuePrincipalExchangeAmount!=null && !presentValuePrincipalExchangeAmount.prune().hasData()) presentValuePrincipalExchangeAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnadjustedPrincipalExchangeDate()!=null) return true;
			if (getAdjustedPrincipalExchangeDate()!=null) return true;
			if (getPrincipalExchangeAmount()!=null) return true;
			if (getDiscountFactor()!=null) return true;
			if (getPresentValuePrincipalExchangeAmount()!=null && getPresentValuePrincipalExchangeAmount().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalExchange.PrincipalExchangeBuilder o = (PrincipalExchange.PrincipalExchangeBuilder) other;
			
			merger.mergeRosetta(getPresentValuePrincipalExchangeAmount(), o.getPresentValuePrincipalExchangeAmount(), this::setPresentValuePrincipalExchangeAmount);
			
			merger.mergeBasic(getUnadjustedPrincipalExchangeDate(), o.getUnadjustedPrincipalExchangeDate(), this::setUnadjustedPrincipalExchangeDate);
			merger.mergeBasic(getAdjustedPrincipalExchangeDate(), o.getAdjustedPrincipalExchangeDate(), this::setAdjustedPrincipalExchangeDate);
			merger.mergeBasic(getPrincipalExchangeAmount(), o.getPrincipalExchangeAmount(), this::setPrincipalExchangeAmount);
			merger.mergeBasic(getDiscountFactor(), o.getDiscountFactor(), this::setDiscountFactor);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchange _that = getType().cast(o);
		
			if (!Objects.equals(unadjustedPrincipalExchangeDate, _that.getUnadjustedPrincipalExchangeDate())) return false;
			if (!Objects.equals(adjustedPrincipalExchangeDate, _that.getAdjustedPrincipalExchangeDate())) return false;
			if (!Objects.equals(principalExchangeAmount, _that.getPrincipalExchangeAmount())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(presentValuePrincipalExchangeAmount, _that.getPresentValuePrincipalExchangeAmount())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (unadjustedPrincipalExchangeDate != null ? unadjustedPrincipalExchangeDate.hashCode() : 0);
			_result = 31 * _result + (adjustedPrincipalExchangeDate != null ? adjustedPrincipalExchangeDate.hashCode() : 0);
			_result = 31 * _result + (principalExchangeAmount != null ? principalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (presentValuePrincipalExchangeAmount != null ? presentValuePrincipalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeBuilder {" +
				"unadjustedPrincipalExchangeDate=" + this.unadjustedPrincipalExchangeDate + ", " +
				"adjustedPrincipalExchangeDate=" + this.adjustedPrincipalExchangeDate + ", " +
				"principalExchangeAmount=" + this.principalExchangeAmount + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"presentValuePrincipalExchangeAmount=" + this.presentValuePrincipalExchangeAmount + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
