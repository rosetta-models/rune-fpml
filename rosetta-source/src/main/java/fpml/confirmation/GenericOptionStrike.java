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
import fpml.confirmation.EquityStrike;
import fpml.confirmation.EquityStrike.EquityStrikeBuilder;
import fpml.confirmation.EquityStrike.EquityStrikeBuilderImpl;
import fpml.confirmation.EquityStrike.EquityStrikeImpl;
import fpml.confirmation.EquityStrikeSequence;
import fpml.confirmation.GenericOptionStrike;
import fpml.confirmation.GenericOptionStrike.GenericOptionStrikeBuilder;
import fpml.confirmation.GenericOptionStrike.GenericOptionStrikeBuilderImpl;
import fpml.confirmation.GenericOptionStrike.GenericOptionStrikeImpl;
import fpml.confirmation.meta.GenericOptionStrikeMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="GenericOptionStrike", builder=GenericOptionStrike.GenericOptionStrikeBuilderImpl.class, version="${project.version}")
public interface GenericOptionStrike extends EquityStrike {

	GenericOptionStrikeMeta metaData = new GenericOptionStrikeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The units in which an amount (not monetary) is denominated.
	 */
	String getUnits();

	/*********************** Build Methods  ***********************/
	GenericOptionStrike build();
	
	GenericOptionStrike.GenericOptionStrikeBuilder toBuilder();
	
	static GenericOptionStrike.GenericOptionStrikeBuilder builder() {
		return new GenericOptionStrike.GenericOptionStrikeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GenericOptionStrike> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GenericOptionStrike> getType() {
		return GenericOptionStrike.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
		processRosetta(path.newSubPath("equityStrikeSequence"), processor, EquityStrikeSequence.class, getEquityStrikeSequence());
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processor.processBasic(path.newSubPath("units"), String.class, getUnits(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface GenericOptionStrikeBuilder extends GenericOptionStrike, EquityStrike.EquityStrikeBuilder {
		GenericOptionStrike.GenericOptionStrikeBuilder setStrikePrice(BigDecimal strikePrice);
		GenericOptionStrike.GenericOptionStrikeBuilder setEquityStrikeSequence(EquityStrikeSequence equityStrikeSequence);
		GenericOptionStrike.GenericOptionStrikeBuilder setCurrency(Currency currency);
		GenericOptionStrike.GenericOptionStrikeBuilder setUnits(String units);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("strikePrice"), BigDecimal.class, getStrikePrice(), this);
			processRosetta(path.newSubPath("equityStrikeSequence"), processor, EquityStrikeSequence.EquityStrikeSequenceBuilder.class, getEquityStrikeSequence());
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processor.processBasic(path.newSubPath("units"), String.class, getUnits(), this);
		}
		

		GenericOptionStrike.GenericOptionStrikeBuilder prune();
	}

	/*********************** Immutable Implementation of GenericOptionStrike  ***********************/
	class GenericOptionStrikeImpl extends EquityStrike.EquityStrikeImpl implements GenericOptionStrike {
		private final String units;
		
		protected GenericOptionStrikeImpl(GenericOptionStrike.GenericOptionStrikeBuilder builder) {
			super(builder);
			this.units = builder.getUnits();
		}
		
		@Override
		@RosettaAttribute("units")
		public String getUnits() {
			return units;
		}
		
		@Override
		public GenericOptionStrike build() {
			return this;
		}
		
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder toBuilder() {
			GenericOptionStrike.GenericOptionStrikeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GenericOptionStrike.GenericOptionStrikeBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnits()).ifPresent(builder::setUnits);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericOptionStrike _that = getType().cast(o);
		
			if (!Objects.equals(units, _that.getUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (units != null ? units.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericOptionStrike {" +
				"units=" + this.units +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GenericOptionStrike  ***********************/
	class GenericOptionStrikeBuilderImpl extends EquityStrike.EquityStrikeBuilderImpl  implements GenericOptionStrike.GenericOptionStrikeBuilder {
	
		protected String units;
	
		public GenericOptionStrikeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("units")
		public String getUnits() {
			return units;
		}
		
		@Override
		@RosettaAttribute("strikePrice")
		public GenericOptionStrike.GenericOptionStrikeBuilder setStrikePrice(BigDecimal strikePrice) {
			this.strikePrice = strikePrice==null?null:strikePrice;
			return this;
		}
		@Override
		@RosettaAttribute("equityStrikeSequence")
		public GenericOptionStrike.GenericOptionStrikeBuilder setEquityStrikeSequence(EquityStrikeSequence equityStrikeSequence) {
			this.equityStrikeSequence = equityStrikeSequence==null?null:equityStrikeSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("currency")
		public GenericOptionStrike.GenericOptionStrikeBuilder setCurrency(Currency currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("units")
		public GenericOptionStrike.GenericOptionStrikeBuilder setUnits(String units) {
			this.units = units==null?null:units;
			return this;
		}
		
		@Override
		public GenericOptionStrike build() {
			return new GenericOptionStrike.GenericOptionStrikeImpl(this);
		}
		
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnits()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GenericOptionStrike.GenericOptionStrikeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			GenericOptionStrike.GenericOptionStrikeBuilder o = (GenericOptionStrike.GenericOptionStrikeBuilder) other;
			
			
			merger.mergeBasic(getUnits(), o.getUnits(), this::setUnits);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GenericOptionStrike _that = getType().cast(o);
		
			if (!Objects.equals(units, _that.getUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (units != null ? units.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GenericOptionStrikeBuilder {" +
				"units=" + this.units +
			'}' + " " + super.toString();
		}
	}
}
