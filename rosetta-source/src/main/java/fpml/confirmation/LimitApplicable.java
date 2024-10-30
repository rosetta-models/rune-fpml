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
import fpml.confirmation.CreditLimitUtilization;
import fpml.confirmation.Currency;
import fpml.confirmation.LimitApplicable;
import fpml.confirmation.LimitApplicable.LimitApplicableBuilder;
import fpml.confirmation.LimitApplicable.LimitApplicableBuilderImpl;
import fpml.confirmation.LimitApplicable.LimitApplicableImpl;
import fpml.confirmation.LimitType;
import fpml.confirmation.Velocity;
import fpml.confirmation.meta.LimitApplicableMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="LimitApplicable", builder=LimitApplicable.LimitApplicableBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface LimitApplicable extends RosettaModelObject {

	LimitApplicableMeta metaData = new LimitApplicableMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Standard code to indicate which type of credit line is being referred to - i.e. IM, DV01, PV01, CS01, Notional, Clip Size, Notional, maximumOrderQuantity
	 */
	LimitType getLimitType();
	Integer getClipSize();
	Integer getAmountUtilized();
	/**
	 * Credit limit utilization breakdown by executed trades and pending orders.
	 */
	CreditLimitUtilization getUtilization();
	Integer getAmountRemaining();
	Currency getCurrency();
	Velocity getVelocity();

	/*********************** Build Methods  ***********************/
	LimitApplicable build();
	
	LimitApplicable.LimitApplicableBuilder toBuilder();
	
	static LimitApplicable.LimitApplicableBuilder builder() {
		return new LimitApplicable.LimitApplicableBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LimitApplicable> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LimitApplicable> getType() {
		return LimitApplicable.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("limitType"), processor, LimitType.class, getLimitType());
		processor.processBasic(path.newSubPath("clipSize"), Integer.class, getClipSize(), this);
		processor.processBasic(path.newSubPath("amountUtilized"), Integer.class, getAmountUtilized(), this);
		processRosetta(path.newSubPath("utilization"), processor, CreditLimitUtilization.class, getUtilization());
		processor.processBasic(path.newSubPath("amountRemaining"), Integer.class, getAmountRemaining(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("velocity"), processor, Velocity.class, getVelocity());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LimitApplicableBuilder extends LimitApplicable, RosettaModelObjectBuilder {
		LimitType.LimitTypeBuilder getOrCreateLimitType();
		LimitType.LimitTypeBuilder getLimitType();
		CreditLimitUtilization.CreditLimitUtilizationBuilder getOrCreateUtilization();
		CreditLimitUtilization.CreditLimitUtilizationBuilder getUtilization();
		Currency.CurrencyBuilder getOrCreateCurrency();
		Currency.CurrencyBuilder getCurrency();
		Velocity.VelocityBuilder getOrCreateVelocity();
		Velocity.VelocityBuilder getVelocity();
		LimitApplicable.LimitApplicableBuilder setLimitType(LimitType limitType);
		LimitApplicable.LimitApplicableBuilder setClipSize(Integer clipSize);
		LimitApplicable.LimitApplicableBuilder setAmountUtilized(Integer amountUtilized);
		LimitApplicable.LimitApplicableBuilder setUtilization(CreditLimitUtilization utilization);
		LimitApplicable.LimitApplicableBuilder setAmountRemaining(Integer amountRemaining);
		LimitApplicable.LimitApplicableBuilder setCurrency(Currency currency);
		LimitApplicable.LimitApplicableBuilder setVelocity(Velocity velocity);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("limitType"), processor, LimitType.LimitTypeBuilder.class, getLimitType());
			processor.processBasic(path.newSubPath("clipSize"), Integer.class, getClipSize(), this);
			processor.processBasic(path.newSubPath("amountUtilized"), Integer.class, getAmountUtilized(), this);
			processRosetta(path.newSubPath("utilization"), processor, CreditLimitUtilization.CreditLimitUtilizationBuilder.class, getUtilization());
			processor.processBasic(path.newSubPath("amountRemaining"), Integer.class, getAmountRemaining(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("velocity"), processor, Velocity.VelocityBuilder.class, getVelocity());
		}
		

		LimitApplicable.LimitApplicableBuilder prune();
	}

	/*********************** Immutable Implementation of LimitApplicable  ***********************/
	class LimitApplicableImpl implements LimitApplicable {
		private final LimitType limitType;
		private final Integer clipSize;
		private final Integer amountUtilized;
		private final CreditLimitUtilization utilization;
		private final Integer amountRemaining;
		private final Currency currency;
		private final Velocity velocity;
		
		protected LimitApplicableImpl(LimitApplicable.LimitApplicableBuilder builder) {
			this.limitType = ofNullable(builder.getLimitType()).map(f->f.build()).orElse(null);
			this.clipSize = builder.getClipSize();
			this.amountUtilized = builder.getAmountUtilized();
			this.utilization = ofNullable(builder.getUtilization()).map(f->f.build()).orElse(null);
			this.amountRemaining = builder.getAmountRemaining();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.velocity = ofNullable(builder.getVelocity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("limitType")
		public LimitType getLimitType() {
			return limitType;
		}
		
		@Override
		@RosettaAttribute("clipSize")
		public Integer getClipSize() {
			return clipSize;
		}
		
		@Override
		@RosettaAttribute("amountUtilized")
		public Integer getAmountUtilized() {
			return amountUtilized;
		}
		
		@Override
		@RosettaAttribute("utilization")
		public CreditLimitUtilization getUtilization() {
			return utilization;
		}
		
		@Override
		@RosettaAttribute("amountRemaining")
		public Integer getAmountRemaining() {
			return amountRemaining;
		}
		
		@Override
		@RosettaAttribute("currency")
		public Currency getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("velocity")
		public Velocity getVelocity() {
			return velocity;
		}
		
		@Override
		public LimitApplicable build() {
			return this;
		}
		
		@Override
		public LimitApplicable.LimitApplicableBuilder toBuilder() {
			LimitApplicable.LimitApplicableBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LimitApplicable.LimitApplicableBuilder builder) {
			ofNullable(getLimitType()).ifPresent(builder::setLimitType);
			ofNullable(getClipSize()).ifPresent(builder::setClipSize);
			ofNullable(getAmountUtilized()).ifPresent(builder::setAmountUtilized);
			ofNullable(getUtilization()).ifPresent(builder::setUtilization);
			ofNullable(getAmountRemaining()).ifPresent(builder::setAmountRemaining);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getVelocity()).ifPresent(builder::setVelocity);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LimitApplicable _that = getType().cast(o);
		
			if (!Objects.equals(limitType, _that.getLimitType())) return false;
			if (!Objects.equals(clipSize, _that.getClipSize())) return false;
			if (!Objects.equals(amountUtilized, _that.getAmountUtilized())) return false;
			if (!Objects.equals(utilization, _that.getUtilization())) return false;
			if (!Objects.equals(amountRemaining, _that.getAmountRemaining())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(velocity, _that.getVelocity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (limitType != null ? limitType.hashCode() : 0);
			_result = 31 * _result + (clipSize != null ? clipSize.hashCode() : 0);
			_result = 31 * _result + (amountUtilized != null ? amountUtilized.hashCode() : 0);
			_result = 31 * _result + (utilization != null ? utilization.hashCode() : 0);
			_result = 31 * _result + (amountRemaining != null ? amountRemaining.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (velocity != null ? velocity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitApplicable {" +
				"limitType=" + this.limitType + ", " +
				"clipSize=" + this.clipSize + ", " +
				"amountUtilized=" + this.amountUtilized + ", " +
				"utilization=" + this.utilization + ", " +
				"amountRemaining=" + this.amountRemaining + ", " +
				"currency=" + this.currency + ", " +
				"velocity=" + this.velocity +
			'}';
		}
	}

	/*********************** Builder Implementation of LimitApplicable  ***********************/
	class LimitApplicableBuilderImpl implements LimitApplicable.LimitApplicableBuilder {
	
		protected LimitType.LimitTypeBuilder limitType;
		protected Integer clipSize;
		protected Integer amountUtilized;
		protected CreditLimitUtilization.CreditLimitUtilizationBuilder utilization;
		protected Integer amountRemaining;
		protected Currency.CurrencyBuilder currency;
		protected Velocity.VelocityBuilder velocity;
	
		public LimitApplicableBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("limitType")
		public LimitType.LimitTypeBuilder getLimitType() {
			return limitType;
		}
		
		@Override
		public LimitType.LimitTypeBuilder getOrCreateLimitType() {
			LimitType.LimitTypeBuilder result;
			if (limitType!=null) {
				result = limitType;
			}
			else {
				result = limitType = LimitType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("clipSize")
		public Integer getClipSize() {
			return clipSize;
		}
		
		@Override
		@RosettaAttribute("amountUtilized")
		public Integer getAmountUtilized() {
			return amountUtilized;
		}
		
		@Override
		@RosettaAttribute("utilization")
		public CreditLimitUtilization.CreditLimitUtilizationBuilder getUtilization() {
			return utilization;
		}
		
		@Override
		public CreditLimitUtilization.CreditLimitUtilizationBuilder getOrCreateUtilization() {
			CreditLimitUtilization.CreditLimitUtilizationBuilder result;
			if (utilization!=null) {
				result = utilization;
			}
			else {
				result = utilization = CreditLimitUtilization.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("amountRemaining")
		public Integer getAmountRemaining() {
			return amountRemaining;
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
		@RosettaAttribute("velocity")
		public Velocity.VelocityBuilder getVelocity() {
			return velocity;
		}
		
		@Override
		public Velocity.VelocityBuilder getOrCreateVelocity() {
			Velocity.VelocityBuilder result;
			if (velocity!=null) {
				result = velocity;
			}
			else {
				result = velocity = Velocity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("limitType")
		public LimitApplicable.LimitApplicableBuilder setLimitType(LimitType limitType) {
			this.limitType = limitType==null?null:limitType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("clipSize")
		public LimitApplicable.LimitApplicableBuilder setClipSize(Integer clipSize) {
			this.clipSize = clipSize==null?null:clipSize;
			return this;
		}
		@Override
		@RosettaAttribute("amountUtilized")
		public LimitApplicable.LimitApplicableBuilder setAmountUtilized(Integer amountUtilized) {
			this.amountUtilized = amountUtilized==null?null:amountUtilized;
			return this;
		}
		@Override
		@RosettaAttribute("utilization")
		public LimitApplicable.LimitApplicableBuilder setUtilization(CreditLimitUtilization utilization) {
			this.utilization = utilization==null?null:utilization.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("amountRemaining")
		public LimitApplicable.LimitApplicableBuilder setAmountRemaining(Integer amountRemaining) {
			this.amountRemaining = amountRemaining==null?null:amountRemaining;
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public LimitApplicable.LimitApplicableBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("velocity")
		public LimitApplicable.LimitApplicableBuilder setVelocity(Velocity velocity) {
			this.velocity = velocity==null?null:velocity.toBuilder();
			return this;
		}
		
		@Override
		public LimitApplicable build() {
			return new LimitApplicable.LimitApplicableImpl(this);
		}
		
		@Override
		public LimitApplicable.LimitApplicableBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitApplicable.LimitApplicableBuilder prune() {
			if (limitType!=null && !limitType.prune().hasData()) limitType = null;
			if (utilization!=null && !utilization.prune().hasData()) utilization = null;
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (velocity!=null && !velocity.prune().hasData()) velocity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLimitType()!=null && getLimitType().hasData()) return true;
			if (getClipSize()!=null) return true;
			if (getAmountUtilized()!=null) return true;
			if (getUtilization()!=null && getUtilization().hasData()) return true;
			if (getAmountRemaining()!=null) return true;
			if (getCurrency()!=null && getCurrency().hasData()) return true;
			if (getVelocity()!=null && getVelocity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LimitApplicable.LimitApplicableBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LimitApplicable.LimitApplicableBuilder o = (LimitApplicable.LimitApplicableBuilder) other;
			
			merger.mergeRosetta(getLimitType(), o.getLimitType(), this::setLimitType);
			merger.mergeRosetta(getUtilization(), o.getUtilization(), this::setUtilization);
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getVelocity(), o.getVelocity(), this::setVelocity);
			
			merger.mergeBasic(getClipSize(), o.getClipSize(), this::setClipSize);
			merger.mergeBasic(getAmountUtilized(), o.getAmountUtilized(), this::setAmountUtilized);
			merger.mergeBasic(getAmountRemaining(), o.getAmountRemaining(), this::setAmountRemaining);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LimitApplicable _that = getType().cast(o);
		
			if (!Objects.equals(limitType, _that.getLimitType())) return false;
			if (!Objects.equals(clipSize, _that.getClipSize())) return false;
			if (!Objects.equals(amountUtilized, _that.getAmountUtilized())) return false;
			if (!Objects.equals(utilization, _that.getUtilization())) return false;
			if (!Objects.equals(amountRemaining, _that.getAmountRemaining())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(velocity, _that.getVelocity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (limitType != null ? limitType.hashCode() : 0);
			_result = 31 * _result + (clipSize != null ? clipSize.hashCode() : 0);
			_result = 31 * _result + (amountUtilized != null ? amountUtilized.hashCode() : 0);
			_result = 31 * _result + (utilization != null ? utilization.hashCode() : 0);
			_result = 31 * _result + (amountRemaining != null ? amountRemaining.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (velocity != null ? velocity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LimitApplicableBuilder {" +
				"limitType=" + this.limitType + ", " +
				"clipSize=" + this.clipSize + ", " +
				"amountUtilized=" + this.amountUtilized + ", " +
				"utilization=" + this.utilization + ", " +
				"amountRemaining=" + this.amountRemaining + ", " +
				"currency=" + this.currency + ", " +
				"velocity=" + this.velocity +
			'}';
		}
	}
}
