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
import fpml.confirmation.UtilizationAmounts;
import fpml.confirmation.UtilizationAmounts.UtilizationAmountsBuilder;
import fpml.confirmation.UtilizationAmounts.UtilizationAmountsBuilderImpl;
import fpml.confirmation.UtilizationAmounts.UtilizationAmountsImpl;
import fpml.confirmation.meta.UtilizationAmountsMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure which defines the total utilization and available credit levels for a given facility.
 * @version ${project.version}
 */
@RosettaDataType(value="UtilizationAmounts", builder=UtilizationAmounts.UtilizationAmountsBuilderImpl.class, version="${project.version}")
public interface UtilizationAmounts extends RosettaModelObject {

	UtilizationAmountsMeta metaData = new UtilizationAmountsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The amount of utilization which is funded.
	 */
	BigDecimal getFundedAmount();
	/**
	 * The amount of utilization which is unfunded.
	 */
	BigDecimal getUnfundedAmount();

	/*********************** Build Methods  ***********************/
	UtilizationAmounts build();
	
	UtilizationAmounts.UtilizationAmountsBuilder toBuilder();
	
	static UtilizationAmounts.UtilizationAmountsBuilder builder() {
		return new UtilizationAmounts.UtilizationAmountsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UtilizationAmounts> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UtilizationAmounts> getType() {
		return UtilizationAmounts.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fundedAmount"), BigDecimal.class, getFundedAmount(), this);
		processor.processBasic(path.newSubPath("unfundedAmount"), BigDecimal.class, getUnfundedAmount(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UtilizationAmountsBuilder extends UtilizationAmounts, RosettaModelObjectBuilder {
		UtilizationAmounts.UtilizationAmountsBuilder setFundedAmount(BigDecimal fundedAmount);
		UtilizationAmounts.UtilizationAmountsBuilder setUnfundedAmount(BigDecimal unfundedAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fundedAmount"), BigDecimal.class, getFundedAmount(), this);
			processor.processBasic(path.newSubPath("unfundedAmount"), BigDecimal.class, getUnfundedAmount(), this);
		}
		

		UtilizationAmounts.UtilizationAmountsBuilder prune();
	}

	/*********************** Immutable Implementation of UtilizationAmounts  ***********************/
	class UtilizationAmountsImpl implements UtilizationAmounts {
		private final BigDecimal fundedAmount;
		private final BigDecimal unfundedAmount;
		
		protected UtilizationAmountsImpl(UtilizationAmounts.UtilizationAmountsBuilder builder) {
			this.fundedAmount = builder.getFundedAmount();
			this.unfundedAmount = builder.getUnfundedAmount();
		}
		
		@Override
		@RosettaAttribute("fundedAmount")
		public BigDecimal getFundedAmount() {
			return fundedAmount;
		}
		
		@Override
		@RosettaAttribute("unfundedAmount")
		public BigDecimal getUnfundedAmount() {
			return unfundedAmount;
		}
		
		@Override
		public UtilizationAmounts build() {
			return this;
		}
		
		@Override
		public UtilizationAmounts.UtilizationAmountsBuilder toBuilder() {
			UtilizationAmounts.UtilizationAmountsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UtilizationAmounts.UtilizationAmountsBuilder builder) {
			ofNullable(getFundedAmount()).ifPresent(builder::setFundedAmount);
			ofNullable(getUnfundedAmount()).ifPresent(builder::setUnfundedAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationAmounts _that = getType().cast(o);
		
			if (!Objects.equals(fundedAmount, _that.getFundedAmount())) return false;
			if (!Objects.equals(unfundedAmount, _that.getUnfundedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fundedAmount != null ? fundedAmount.hashCode() : 0);
			_result = 31 * _result + (unfundedAmount != null ? unfundedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationAmounts {" +
				"fundedAmount=" + this.fundedAmount + ", " +
				"unfundedAmount=" + this.unfundedAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of UtilizationAmounts  ***********************/
	class UtilizationAmountsBuilderImpl implements UtilizationAmounts.UtilizationAmountsBuilder {
	
		protected BigDecimal fundedAmount;
		protected BigDecimal unfundedAmount;
	
		public UtilizationAmountsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fundedAmount")
		public BigDecimal getFundedAmount() {
			return fundedAmount;
		}
		
		@Override
		@RosettaAttribute("unfundedAmount")
		public BigDecimal getUnfundedAmount() {
			return unfundedAmount;
		}
		
		@Override
		@RosettaAttribute("fundedAmount")
		public UtilizationAmounts.UtilizationAmountsBuilder setFundedAmount(BigDecimal fundedAmount) {
			this.fundedAmount = fundedAmount==null?null:fundedAmount;
			return this;
		}
		@Override
		@RosettaAttribute("unfundedAmount")
		public UtilizationAmounts.UtilizationAmountsBuilder setUnfundedAmount(BigDecimal unfundedAmount) {
			this.unfundedAmount = unfundedAmount==null?null:unfundedAmount;
			return this;
		}
		
		@Override
		public UtilizationAmounts build() {
			return new UtilizationAmounts.UtilizationAmountsImpl(this);
		}
		
		@Override
		public UtilizationAmounts.UtilizationAmountsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationAmounts.UtilizationAmountsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFundedAmount()!=null) return true;
			if (getUnfundedAmount()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UtilizationAmounts.UtilizationAmountsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UtilizationAmounts.UtilizationAmountsBuilder o = (UtilizationAmounts.UtilizationAmountsBuilder) other;
			
			
			merger.mergeBasic(getFundedAmount(), o.getFundedAmount(), this::setFundedAmount);
			merger.mergeBasic(getUnfundedAmount(), o.getUnfundedAmount(), this::setUnfundedAmount);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UtilizationAmounts _that = getType().cast(o);
		
			if (!Objects.equals(fundedAmount, _that.getFundedAmount())) return false;
			if (!Objects.equals(unfundedAmount, _that.getUnfundedAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fundedAmount != null ? fundedAmount.hashCode() : 0);
			_result = 31 * _result + (unfundedAmount != null ? unfundedAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UtilizationAmountsBuilder {" +
				"fundedAmount=" + this.fundedAmount + ", " +
				"unfundedAmount=" + this.unfundedAmount +
			'}';
		}
	}
}
