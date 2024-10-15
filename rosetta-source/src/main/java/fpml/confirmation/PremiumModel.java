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
import fpml.confirmation.Money;
import fpml.confirmation.PremiumModel;
import fpml.confirmation.PremiumModel.PremiumModelBuilder;
import fpml.confirmation.PremiumModel.PremiumModelBuilderImpl;
import fpml.confirmation.PremiumModel.PremiumModelImpl;
import fpml.confirmation.PremiumTypeEnum;
import fpml.confirmation.meta.PremiumModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model group for representing the option premium when expressed in a way other than an amount.
 * @version ${project.version}
 */
@RosettaDataType(value="PremiumModel", builder=PremiumModel.PremiumModelBuilderImpl.class, version="${project.version}")
public interface PremiumModel extends RosettaModelObject {

	PremiumModelMeta metaData = new PremiumModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Forward start Premium type
	 */
	PremiumTypeEnum getPremiumType();
	/**
	 * The amount of premium to be paid expressed as a function of the number of options.
	 */
	Money getPricePerOption();
	/**
	 * The amount of premium to be paid expressed as a percentage of the notional value of the transaction. A percentage of 5% would be expressed as 0.05.
	 */
	BigDecimal getPercentageOfNotional();

	/*********************** Build Methods  ***********************/
	PremiumModel build();
	
	PremiumModel.PremiumModelBuilder toBuilder();
	
	static PremiumModel.PremiumModelBuilder builder() {
		return new PremiumModel.PremiumModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PremiumModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PremiumModel> getType() {
		return PremiumModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("premiumType"), PremiumTypeEnum.class, getPremiumType(), this);
		processRosetta(path.newSubPath("pricePerOption"), processor, Money.class, getPricePerOption());
		processor.processBasic(path.newSubPath("percentageOfNotional"), BigDecimal.class, getPercentageOfNotional(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PremiumModelBuilder extends PremiumModel, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreatePricePerOption();
		Money.MoneyBuilder getPricePerOption();
		PremiumModel.PremiumModelBuilder setPremiumType(PremiumTypeEnum premiumType);
		PremiumModel.PremiumModelBuilder setPricePerOption(Money pricePerOption);
		PremiumModel.PremiumModelBuilder setPercentageOfNotional(BigDecimal percentageOfNotional);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("premiumType"), PremiumTypeEnum.class, getPremiumType(), this);
			processRosetta(path.newSubPath("pricePerOption"), processor, Money.MoneyBuilder.class, getPricePerOption());
			processor.processBasic(path.newSubPath("percentageOfNotional"), BigDecimal.class, getPercentageOfNotional(), this);
		}
		

		PremiumModel.PremiumModelBuilder prune();
	}

	/*********************** Immutable Implementation of PremiumModel  ***********************/
	class PremiumModelImpl implements PremiumModel {
		private final PremiumTypeEnum premiumType;
		private final Money pricePerOption;
		private final BigDecimal percentageOfNotional;
		
		protected PremiumModelImpl(PremiumModel.PremiumModelBuilder builder) {
			this.premiumType = builder.getPremiumType();
			this.pricePerOption = ofNullable(builder.getPricePerOption()).map(f->f.build()).orElse(null);
			this.percentageOfNotional = builder.getPercentageOfNotional();
		}
		
		@Override
		@RosettaAttribute("premiumType")
		public PremiumTypeEnum getPremiumType() {
			return premiumType;
		}
		
		@Override
		@RosettaAttribute("pricePerOption")
		public Money getPricePerOption() {
			return pricePerOption;
		}
		
		@Override
		@RosettaAttribute("percentageOfNotional")
		public BigDecimal getPercentageOfNotional() {
			return percentageOfNotional;
		}
		
		@Override
		public PremiumModel build() {
			return this;
		}
		
		@Override
		public PremiumModel.PremiumModelBuilder toBuilder() {
			PremiumModel.PremiumModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PremiumModel.PremiumModelBuilder builder) {
			ofNullable(getPremiumType()).ifPresent(builder::setPremiumType);
			ofNullable(getPricePerOption()).ifPresent(builder::setPricePerOption);
			ofNullable(getPercentageOfNotional()).ifPresent(builder::setPercentageOfNotional);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PremiumModel _that = getType().cast(o);
		
			if (!Objects.equals(premiumType, _that.getPremiumType())) return false;
			if (!Objects.equals(pricePerOption, _that.getPricePerOption())) return false;
			if (!Objects.equals(percentageOfNotional, _that.getPercentageOfNotional())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (premiumType != null ? premiumType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pricePerOption != null ? pricePerOption.hashCode() : 0);
			_result = 31 * _result + (percentageOfNotional != null ? percentageOfNotional.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PremiumModel {" +
				"premiumType=" + this.premiumType + ", " +
				"pricePerOption=" + this.pricePerOption + ", " +
				"percentageOfNotional=" + this.percentageOfNotional +
			'}';
		}
	}

	/*********************** Builder Implementation of PremiumModel  ***********************/
	class PremiumModelBuilderImpl implements PremiumModel.PremiumModelBuilder {
	
		protected PremiumTypeEnum premiumType;
		protected Money.MoneyBuilder pricePerOption;
		protected BigDecimal percentageOfNotional;
	
		public PremiumModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("premiumType")
		public PremiumTypeEnum getPremiumType() {
			return premiumType;
		}
		
		@Override
		@RosettaAttribute("pricePerOption")
		public Money.MoneyBuilder getPricePerOption() {
			return pricePerOption;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePricePerOption() {
			Money.MoneyBuilder result;
			if (pricePerOption!=null) {
				result = pricePerOption;
			}
			else {
				result = pricePerOption = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("percentageOfNotional")
		public BigDecimal getPercentageOfNotional() {
			return percentageOfNotional;
		}
		
		@Override
		@RosettaAttribute("premiumType")
		public PremiumModel.PremiumModelBuilder setPremiumType(PremiumTypeEnum premiumType) {
			this.premiumType = premiumType==null?null:premiumType;
			return this;
		}
		@Override
		@RosettaAttribute("pricePerOption")
		public PremiumModel.PremiumModelBuilder setPricePerOption(Money pricePerOption) {
			this.pricePerOption = pricePerOption==null?null:pricePerOption.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("percentageOfNotional")
		public PremiumModel.PremiumModelBuilder setPercentageOfNotional(BigDecimal percentageOfNotional) {
			this.percentageOfNotional = percentageOfNotional==null?null:percentageOfNotional;
			return this;
		}
		
		@Override
		public PremiumModel build() {
			return new PremiumModel.PremiumModelImpl(this);
		}
		
		@Override
		public PremiumModel.PremiumModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PremiumModel.PremiumModelBuilder prune() {
			if (pricePerOption!=null && !pricePerOption.prune().hasData()) pricePerOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPremiumType()!=null) return true;
			if (getPricePerOption()!=null && getPricePerOption().hasData()) return true;
			if (getPercentageOfNotional()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PremiumModel.PremiumModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PremiumModel.PremiumModelBuilder o = (PremiumModel.PremiumModelBuilder) other;
			
			merger.mergeRosetta(getPricePerOption(), o.getPricePerOption(), this::setPricePerOption);
			
			merger.mergeBasic(getPremiumType(), o.getPremiumType(), this::setPremiumType);
			merger.mergeBasic(getPercentageOfNotional(), o.getPercentageOfNotional(), this::setPercentageOfNotional);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PremiumModel _that = getType().cast(o);
		
			if (!Objects.equals(premiumType, _that.getPremiumType())) return false;
			if (!Objects.equals(pricePerOption, _that.getPricePerOption())) return false;
			if (!Objects.equals(percentageOfNotional, _that.getPercentageOfNotional())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (premiumType != null ? premiumType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (pricePerOption != null ? pricePerOption.hashCode() : 0);
			_result = 31 * _result + (percentageOfNotional != null ? percentageOfNotional.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PremiumModelBuilder {" +
				"premiumType=" + this.premiumType + ", " +
				"pricePerOption=" + this.pricePerOption + ", " +
				"percentageOfNotional=" + this.percentageOfNotional +
			'}';
		}
	}
}
