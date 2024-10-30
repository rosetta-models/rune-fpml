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
import fpml.confirmation.InstrumentTradeQuantity;
import fpml.confirmation.InstrumentTradeQuantity.InstrumentTradeQuantityBuilder;
import fpml.confirmation.InstrumentTradeQuantity.InstrumentTradeQuantityBuilderImpl;
import fpml.confirmation.InstrumentTradeQuantity.InstrumentTradeQuantityImpl;
import fpml.confirmation.Money;
import fpml.confirmation.meta.InstrumentTradeQuantityMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure describing the amount of an instrument that was traded.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="InstrumentTradeQuantity", builder=InstrumentTradeQuantity.InstrumentTradeQuantityBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface InstrumentTradeQuantity extends RosettaModelObject {

	InstrumentTradeQuantityMeta metaData = new InstrumentTradeQuantityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The (absolute) number of units of the underlying instrument that were traded.
	 */
	BigDecimal getNumber();
	/**
	 * The monetary value of the security (eg. fixed income security) that was traded).
	 */
	Money getNominal();

	/*********************** Build Methods  ***********************/
	InstrumentTradeQuantity build();
	
	InstrumentTradeQuantity.InstrumentTradeQuantityBuilder toBuilder();
	
	static InstrumentTradeQuantity.InstrumentTradeQuantityBuilder builder() {
		return new InstrumentTradeQuantity.InstrumentTradeQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentTradeQuantity> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InstrumentTradeQuantity> getType() {
		return InstrumentTradeQuantity.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("number"), BigDecimal.class, getNumber(), this);
		processRosetta(path.newSubPath("nominal"), processor, Money.class, getNominal());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentTradeQuantityBuilder extends InstrumentTradeQuantity, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateNominal();
		Money.MoneyBuilder getNominal();
		InstrumentTradeQuantity.InstrumentTradeQuantityBuilder setNumber(BigDecimal number);
		InstrumentTradeQuantity.InstrumentTradeQuantityBuilder setNominal(Money nominal);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("number"), BigDecimal.class, getNumber(), this);
			processRosetta(path.newSubPath("nominal"), processor, Money.MoneyBuilder.class, getNominal());
		}
		

		InstrumentTradeQuantity.InstrumentTradeQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of InstrumentTradeQuantity  ***********************/
	class InstrumentTradeQuantityImpl implements InstrumentTradeQuantity {
		private final BigDecimal number;
		private final Money nominal;
		
		protected InstrumentTradeQuantityImpl(InstrumentTradeQuantity.InstrumentTradeQuantityBuilder builder) {
			this.number = builder.getNumber();
			this.nominal = ofNullable(builder.getNominal()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("number")
		public BigDecimal getNumber() {
			return number;
		}
		
		@Override
		@RosettaAttribute("nominal")
		public Money getNominal() {
			return nominal;
		}
		
		@Override
		public InstrumentTradeQuantity build() {
			return this;
		}
		
		@Override
		public InstrumentTradeQuantity.InstrumentTradeQuantityBuilder toBuilder() {
			InstrumentTradeQuantity.InstrumentTradeQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentTradeQuantity.InstrumentTradeQuantityBuilder builder) {
			ofNullable(getNumber()).ifPresent(builder::setNumber);
			ofNullable(getNominal()).ifPresent(builder::setNominal);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentTradeQuantity _that = getType().cast(o);
		
			if (!Objects.equals(number, _that.getNumber())) return false;
			if (!Objects.equals(nominal, _that.getNominal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (number != null ? number.hashCode() : 0);
			_result = 31 * _result + (nominal != null ? nominal.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTradeQuantity {" +
				"number=" + this.number + ", " +
				"nominal=" + this.nominal +
			'}';
		}
	}

	/*********************** Builder Implementation of InstrumentTradeQuantity  ***********************/
	class InstrumentTradeQuantityBuilderImpl implements InstrumentTradeQuantity.InstrumentTradeQuantityBuilder {
	
		protected BigDecimal number;
		protected Money.MoneyBuilder nominal;
	
		public InstrumentTradeQuantityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("number")
		public BigDecimal getNumber() {
			return number;
		}
		
		@Override
		@RosettaAttribute("nominal")
		public Money.MoneyBuilder getNominal() {
			return nominal;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateNominal() {
			Money.MoneyBuilder result;
			if (nominal!=null) {
				result = nominal;
			}
			else {
				result = nominal = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("number")
		public InstrumentTradeQuantity.InstrumentTradeQuantityBuilder setNumber(BigDecimal number) {
			this.number = number==null?null:number;
			return this;
		}
		@Override
		@RosettaAttribute("nominal")
		public InstrumentTradeQuantity.InstrumentTradeQuantityBuilder setNominal(Money nominal) {
			this.nominal = nominal==null?null:nominal.toBuilder();
			return this;
		}
		
		@Override
		public InstrumentTradeQuantity build() {
			return new InstrumentTradeQuantity.InstrumentTradeQuantityImpl(this);
		}
		
		@Override
		public InstrumentTradeQuantity.InstrumentTradeQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentTradeQuantity.InstrumentTradeQuantityBuilder prune() {
			if (nominal!=null && !nominal.prune().hasData()) nominal = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNumber()!=null) return true;
			if (getNominal()!=null && getNominal().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentTradeQuantity.InstrumentTradeQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InstrumentTradeQuantity.InstrumentTradeQuantityBuilder o = (InstrumentTradeQuantity.InstrumentTradeQuantityBuilder) other;
			
			merger.mergeRosetta(getNominal(), o.getNominal(), this::setNominal);
			
			merger.mergeBasic(getNumber(), o.getNumber(), this::setNumber);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentTradeQuantity _that = getType().cast(o);
		
			if (!Objects.equals(number, _that.getNumber())) return false;
			if (!Objects.equals(nominal, _that.getNominal())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (number != null ? number.hashCode() : 0);
			_result = 31 * _result + (nominal != null ? nominal.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTradeQuantityBuilder {" +
				"number=" + this.number + ", " +
				"nominal=" + this.nominal +
			'}';
		}
	}
}
