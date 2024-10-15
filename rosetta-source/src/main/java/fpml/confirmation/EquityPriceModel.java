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
import fpml.confirmation.ActualPrice;
import fpml.confirmation.EquityPriceModel;
import fpml.confirmation.EquityPriceModel.EquityPriceModelBuilder;
import fpml.confirmation.EquityPriceModel.EquityPriceModelBuilderImpl;
import fpml.confirmation.EquityPriceModel.EquityPriceModelImpl;
import fpml.confirmation.FxConversion;
import fpml.confirmation.meta.EquityPriceModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="EquityPriceModel", builder=EquityPriceModel.EquityPriceModelBuilderImpl.class, version="${project.version}")
public interface EquityPriceModel extends RosettaModelObject {

	EquityPriceModelMeta metaData = new EquityPriceModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the price of the underlyer, before commissions.
	 */
	ActualPrice getGrossPrice();
	/**
	 * Specifies the price of the underlyer, net of commissions.
	 */
	ActualPrice getNetPrice();
	/**
	 * Specifies the accrued interest that are part of the dirty price in the case of a fixed income security or a convertible bond. Expressed in percentage of the notional.
	 */
	BigDecimal getAccruedInterestPrice();
	/**
	 * Specifies the currency conversion rate that applies to an amount. This rate can either be defined elsewhere in the document (case of a quanto swap), or explicitly described through this component.
	 */
	FxConversion getFxConversion();

	/*********************** Build Methods  ***********************/
	EquityPriceModel build();
	
	EquityPriceModel.EquityPriceModelBuilder toBuilder();
	
	static EquityPriceModel.EquityPriceModelBuilder builder() {
		return new EquityPriceModel.EquityPriceModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EquityPriceModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EquityPriceModel> getType() {
		return EquityPriceModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("grossPrice"), processor, ActualPrice.class, getGrossPrice());
		processRosetta(path.newSubPath("netPrice"), processor, ActualPrice.class, getNetPrice());
		processor.processBasic(path.newSubPath("accruedInterestPrice"), BigDecimal.class, getAccruedInterestPrice(), this);
		processRosetta(path.newSubPath("fxConversion"), processor, FxConversion.class, getFxConversion());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EquityPriceModelBuilder extends EquityPriceModel, RosettaModelObjectBuilder {
		ActualPrice.ActualPriceBuilder getOrCreateGrossPrice();
		ActualPrice.ActualPriceBuilder getGrossPrice();
		ActualPrice.ActualPriceBuilder getOrCreateNetPrice();
		ActualPrice.ActualPriceBuilder getNetPrice();
		FxConversion.FxConversionBuilder getOrCreateFxConversion();
		FxConversion.FxConversionBuilder getFxConversion();
		EquityPriceModel.EquityPriceModelBuilder setGrossPrice(ActualPrice grossPrice);
		EquityPriceModel.EquityPriceModelBuilder setNetPrice(ActualPrice netPrice);
		EquityPriceModel.EquityPriceModelBuilder setAccruedInterestPrice(BigDecimal accruedInterestPrice);
		EquityPriceModel.EquityPriceModelBuilder setFxConversion(FxConversion fxConversion);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("grossPrice"), processor, ActualPrice.ActualPriceBuilder.class, getGrossPrice());
			processRosetta(path.newSubPath("netPrice"), processor, ActualPrice.ActualPriceBuilder.class, getNetPrice());
			processor.processBasic(path.newSubPath("accruedInterestPrice"), BigDecimal.class, getAccruedInterestPrice(), this);
			processRosetta(path.newSubPath("fxConversion"), processor, FxConversion.FxConversionBuilder.class, getFxConversion());
		}
		

		EquityPriceModel.EquityPriceModelBuilder prune();
	}

	/*********************** Immutable Implementation of EquityPriceModel  ***********************/
	class EquityPriceModelImpl implements EquityPriceModel {
		private final ActualPrice grossPrice;
		private final ActualPrice netPrice;
		private final BigDecimal accruedInterestPrice;
		private final FxConversion fxConversion;
		
		protected EquityPriceModelImpl(EquityPriceModel.EquityPriceModelBuilder builder) {
			this.grossPrice = ofNullable(builder.getGrossPrice()).map(f->f.build()).orElse(null);
			this.netPrice = ofNullable(builder.getNetPrice()).map(f->f.build()).orElse(null);
			this.accruedInterestPrice = builder.getAccruedInterestPrice();
			this.fxConversion = ofNullable(builder.getFxConversion()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("grossPrice")
		public ActualPrice getGrossPrice() {
			return grossPrice;
		}
		
		@Override
		@RosettaAttribute("netPrice")
		public ActualPrice getNetPrice() {
			return netPrice;
		}
		
		@Override
		@RosettaAttribute("accruedInterestPrice")
		public BigDecimal getAccruedInterestPrice() {
			return accruedInterestPrice;
		}
		
		@Override
		@RosettaAttribute("fxConversion")
		public FxConversion getFxConversion() {
			return fxConversion;
		}
		
		@Override
		public EquityPriceModel build() {
			return this;
		}
		
		@Override
		public EquityPriceModel.EquityPriceModelBuilder toBuilder() {
			EquityPriceModel.EquityPriceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EquityPriceModel.EquityPriceModelBuilder builder) {
			ofNullable(getGrossPrice()).ifPresent(builder::setGrossPrice);
			ofNullable(getNetPrice()).ifPresent(builder::setNetPrice);
			ofNullable(getAccruedInterestPrice()).ifPresent(builder::setAccruedInterestPrice);
			ofNullable(getFxConversion()).ifPresent(builder::setFxConversion);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityPriceModel _that = getType().cast(o);
		
			if (!Objects.equals(grossPrice, _that.getGrossPrice())) return false;
			if (!Objects.equals(netPrice, _that.getNetPrice())) return false;
			if (!Objects.equals(accruedInterestPrice, _that.getAccruedInterestPrice())) return false;
			if (!Objects.equals(fxConversion, _that.getFxConversion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (grossPrice != null ? grossPrice.hashCode() : 0);
			_result = 31 * _result + (netPrice != null ? netPrice.hashCode() : 0);
			_result = 31 * _result + (accruedInterestPrice != null ? accruedInterestPrice.hashCode() : 0);
			_result = 31 * _result + (fxConversion != null ? fxConversion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityPriceModel {" +
				"grossPrice=" + this.grossPrice + ", " +
				"netPrice=" + this.netPrice + ", " +
				"accruedInterestPrice=" + this.accruedInterestPrice + ", " +
				"fxConversion=" + this.fxConversion +
			'}';
		}
	}

	/*********************** Builder Implementation of EquityPriceModel  ***********************/
	class EquityPriceModelBuilderImpl implements EquityPriceModel.EquityPriceModelBuilder {
	
		protected ActualPrice.ActualPriceBuilder grossPrice;
		protected ActualPrice.ActualPriceBuilder netPrice;
		protected BigDecimal accruedInterestPrice;
		protected FxConversion.FxConversionBuilder fxConversion;
	
		public EquityPriceModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("grossPrice")
		public ActualPrice.ActualPriceBuilder getGrossPrice() {
			return grossPrice;
		}
		
		@Override
		public ActualPrice.ActualPriceBuilder getOrCreateGrossPrice() {
			ActualPrice.ActualPriceBuilder result;
			if (grossPrice!=null) {
				result = grossPrice;
			}
			else {
				result = grossPrice = ActualPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("netPrice")
		public ActualPrice.ActualPriceBuilder getNetPrice() {
			return netPrice;
		}
		
		@Override
		public ActualPrice.ActualPriceBuilder getOrCreateNetPrice() {
			ActualPrice.ActualPriceBuilder result;
			if (netPrice!=null) {
				result = netPrice;
			}
			else {
				result = netPrice = ActualPrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accruedInterestPrice")
		public BigDecimal getAccruedInterestPrice() {
			return accruedInterestPrice;
		}
		
		@Override
		@RosettaAttribute("fxConversion")
		public FxConversion.FxConversionBuilder getFxConversion() {
			return fxConversion;
		}
		
		@Override
		public FxConversion.FxConversionBuilder getOrCreateFxConversion() {
			FxConversion.FxConversionBuilder result;
			if (fxConversion!=null) {
				result = fxConversion;
			}
			else {
				result = fxConversion = FxConversion.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("grossPrice")
		public EquityPriceModel.EquityPriceModelBuilder setGrossPrice(ActualPrice grossPrice) {
			this.grossPrice = grossPrice==null?null:grossPrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("netPrice")
		public EquityPriceModel.EquityPriceModelBuilder setNetPrice(ActualPrice netPrice) {
			this.netPrice = netPrice==null?null:netPrice.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accruedInterestPrice")
		public EquityPriceModel.EquityPriceModelBuilder setAccruedInterestPrice(BigDecimal accruedInterestPrice) {
			this.accruedInterestPrice = accruedInterestPrice==null?null:accruedInterestPrice;
			return this;
		}
		@Override
		@RosettaAttribute("fxConversion")
		public EquityPriceModel.EquityPriceModelBuilder setFxConversion(FxConversion fxConversion) {
			this.fxConversion = fxConversion==null?null:fxConversion.toBuilder();
			return this;
		}
		
		@Override
		public EquityPriceModel build() {
			return new EquityPriceModel.EquityPriceModelImpl(this);
		}
		
		@Override
		public EquityPriceModel.EquityPriceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityPriceModel.EquityPriceModelBuilder prune() {
			if (grossPrice!=null && !grossPrice.prune().hasData()) grossPrice = null;
			if (netPrice!=null && !netPrice.prune().hasData()) netPrice = null;
			if (fxConversion!=null && !fxConversion.prune().hasData()) fxConversion = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGrossPrice()!=null && getGrossPrice().hasData()) return true;
			if (getNetPrice()!=null && getNetPrice().hasData()) return true;
			if (getAccruedInterestPrice()!=null) return true;
			if (getFxConversion()!=null && getFxConversion().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EquityPriceModel.EquityPriceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EquityPriceModel.EquityPriceModelBuilder o = (EquityPriceModel.EquityPriceModelBuilder) other;
			
			merger.mergeRosetta(getGrossPrice(), o.getGrossPrice(), this::setGrossPrice);
			merger.mergeRosetta(getNetPrice(), o.getNetPrice(), this::setNetPrice);
			merger.mergeRosetta(getFxConversion(), o.getFxConversion(), this::setFxConversion);
			
			merger.mergeBasic(getAccruedInterestPrice(), o.getAccruedInterestPrice(), this::setAccruedInterestPrice);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EquityPriceModel _that = getType().cast(o);
		
			if (!Objects.equals(grossPrice, _that.getGrossPrice())) return false;
			if (!Objects.equals(netPrice, _that.getNetPrice())) return false;
			if (!Objects.equals(accruedInterestPrice, _that.getAccruedInterestPrice())) return false;
			if (!Objects.equals(fxConversion, _that.getFxConversion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (grossPrice != null ? grossPrice.hashCode() : 0);
			_result = 31 * _result + (netPrice != null ? netPrice.hashCode() : 0);
			_result = 31 * _result + (accruedInterestPrice != null ? accruedInterestPrice.hashCode() : 0);
			_result = 31 * _result + (fxConversion != null ? fxConversion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EquityPriceModelBuilder {" +
				"grossPrice=" + this.grossPrice + ", " +
				"netPrice=" + this.netPrice + ", " +
				"accruedInterestPrice=" + this.accruedInterestPrice + ", " +
				"fxConversion=" + this.fxConversion +
			'}';
		}
	}
}
