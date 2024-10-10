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
import fpml.confirmation.StockLoanModel;
import fpml.confirmation.StockLoanModel.StockLoanModelBuilder;
import fpml.confirmation.StockLoanModel.StockLoanModelBuilderImpl;
import fpml.confirmation.StockLoanModel.StockLoanModelImpl;
import fpml.confirmation.meta.StockLoanModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Stock Loan Content Model
 * @version ${project.version}
 */
@RosettaDataType(value="StockLoanModel", builder=StockLoanModel.StockLoanModelBuilderImpl.class, version="${project.version}")
public interface StockLoanModel extends RosettaModelObject {

	StockLoanModelMeta metaData = new StockLoanModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If true, then loss of stock borrow is applicable.
	 */
	Boolean getLossOfStockBorrow();
	/**
	 * Specifies the maximum stock loan rate for Loss of Stock Borrow.
	 */
	BigDecimal getMaximumStockLoanRate();
	/**
	 * If true, then increased cost of stock borrow is applicable.
	 */
	Boolean getIncreasedCostOfStockBorrow();
	/**
	 * Specifies the initial stock loan rate for Increased Cost of Stock Borrow.
	 */
	BigDecimal getInitialStockLoanRate();

	/*********************** Build Methods  ***********************/
	StockLoanModel build();
	
	StockLoanModel.StockLoanModelBuilder toBuilder();
	
	static StockLoanModel.StockLoanModelBuilder builder() {
		return new StockLoanModel.StockLoanModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StockLoanModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends StockLoanModel> getType() {
		return StockLoanModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("lossOfStockBorrow"), Boolean.class, getLossOfStockBorrow(), this);
		processor.processBasic(path.newSubPath("maximumStockLoanRate"), BigDecimal.class, getMaximumStockLoanRate(), this);
		processor.processBasic(path.newSubPath("increasedCostOfStockBorrow"), Boolean.class, getIncreasedCostOfStockBorrow(), this);
		processor.processBasic(path.newSubPath("initialStockLoanRate"), BigDecimal.class, getInitialStockLoanRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface StockLoanModelBuilder extends StockLoanModel, RosettaModelObjectBuilder {
		StockLoanModel.StockLoanModelBuilder setLossOfStockBorrow(Boolean lossOfStockBorrow);
		StockLoanModel.StockLoanModelBuilder setMaximumStockLoanRate(BigDecimal maximumStockLoanRate);
		StockLoanModel.StockLoanModelBuilder setIncreasedCostOfStockBorrow(Boolean increasedCostOfStockBorrow);
		StockLoanModel.StockLoanModelBuilder setInitialStockLoanRate(BigDecimal initialStockLoanRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("lossOfStockBorrow"), Boolean.class, getLossOfStockBorrow(), this);
			processor.processBasic(path.newSubPath("maximumStockLoanRate"), BigDecimal.class, getMaximumStockLoanRate(), this);
			processor.processBasic(path.newSubPath("increasedCostOfStockBorrow"), Boolean.class, getIncreasedCostOfStockBorrow(), this);
			processor.processBasic(path.newSubPath("initialStockLoanRate"), BigDecimal.class, getInitialStockLoanRate(), this);
		}
		

		StockLoanModel.StockLoanModelBuilder prune();
	}

	/*********************** Immutable Implementation of StockLoanModel  ***********************/
	class StockLoanModelImpl implements StockLoanModel {
		private final Boolean lossOfStockBorrow;
		private final BigDecimal maximumStockLoanRate;
		private final Boolean increasedCostOfStockBorrow;
		private final BigDecimal initialStockLoanRate;
		
		protected StockLoanModelImpl(StockLoanModel.StockLoanModelBuilder builder) {
			this.lossOfStockBorrow = builder.getLossOfStockBorrow();
			this.maximumStockLoanRate = builder.getMaximumStockLoanRate();
			this.increasedCostOfStockBorrow = builder.getIncreasedCostOfStockBorrow();
			this.initialStockLoanRate = builder.getInitialStockLoanRate();
		}
		
		@Override
		@RosettaAttribute("lossOfStockBorrow")
		public Boolean getLossOfStockBorrow() {
			return lossOfStockBorrow;
		}
		
		@Override
		@RosettaAttribute("maximumStockLoanRate")
		public BigDecimal getMaximumStockLoanRate() {
			return maximumStockLoanRate;
		}
		
		@Override
		@RosettaAttribute("increasedCostOfStockBorrow")
		public Boolean getIncreasedCostOfStockBorrow() {
			return increasedCostOfStockBorrow;
		}
		
		@Override
		@RosettaAttribute("initialStockLoanRate")
		public BigDecimal getInitialStockLoanRate() {
			return initialStockLoanRate;
		}
		
		@Override
		public StockLoanModel build() {
			return this;
		}
		
		@Override
		public StockLoanModel.StockLoanModelBuilder toBuilder() {
			StockLoanModel.StockLoanModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StockLoanModel.StockLoanModelBuilder builder) {
			ofNullable(getLossOfStockBorrow()).ifPresent(builder::setLossOfStockBorrow);
			ofNullable(getMaximumStockLoanRate()).ifPresent(builder::setMaximumStockLoanRate);
			ofNullable(getIncreasedCostOfStockBorrow()).ifPresent(builder::setIncreasedCostOfStockBorrow);
			ofNullable(getInitialStockLoanRate()).ifPresent(builder::setInitialStockLoanRate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StockLoanModel _that = getType().cast(o);
		
			if (!Objects.equals(lossOfStockBorrow, _that.getLossOfStockBorrow())) return false;
			if (!Objects.equals(maximumStockLoanRate, _that.getMaximumStockLoanRate())) return false;
			if (!Objects.equals(increasedCostOfStockBorrow, _that.getIncreasedCostOfStockBorrow())) return false;
			if (!Objects.equals(initialStockLoanRate, _that.getInitialStockLoanRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lossOfStockBorrow != null ? lossOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (maximumStockLoanRate != null ? maximumStockLoanRate.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfStockBorrow != null ? increasedCostOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (initialStockLoanRate != null ? initialStockLoanRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StockLoanModel {" +
				"lossOfStockBorrow=" + this.lossOfStockBorrow + ", " +
				"maximumStockLoanRate=" + this.maximumStockLoanRate + ", " +
				"increasedCostOfStockBorrow=" + this.increasedCostOfStockBorrow + ", " +
				"initialStockLoanRate=" + this.initialStockLoanRate +
			'}';
		}
	}

	/*********************** Builder Implementation of StockLoanModel  ***********************/
	class StockLoanModelBuilderImpl implements StockLoanModel.StockLoanModelBuilder {
	
		protected Boolean lossOfStockBorrow;
		protected BigDecimal maximumStockLoanRate;
		protected Boolean increasedCostOfStockBorrow;
		protected BigDecimal initialStockLoanRate;
	
		public StockLoanModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lossOfStockBorrow")
		public Boolean getLossOfStockBorrow() {
			return lossOfStockBorrow;
		}
		
		@Override
		@RosettaAttribute("maximumStockLoanRate")
		public BigDecimal getMaximumStockLoanRate() {
			return maximumStockLoanRate;
		}
		
		@Override
		@RosettaAttribute("increasedCostOfStockBorrow")
		public Boolean getIncreasedCostOfStockBorrow() {
			return increasedCostOfStockBorrow;
		}
		
		@Override
		@RosettaAttribute("initialStockLoanRate")
		public BigDecimal getInitialStockLoanRate() {
			return initialStockLoanRate;
		}
		
		@Override
		@RosettaAttribute("lossOfStockBorrow")
		public StockLoanModel.StockLoanModelBuilder setLossOfStockBorrow(Boolean lossOfStockBorrow) {
			this.lossOfStockBorrow = lossOfStockBorrow==null?null:lossOfStockBorrow;
			return this;
		}
		@Override
		@RosettaAttribute("maximumStockLoanRate")
		public StockLoanModel.StockLoanModelBuilder setMaximumStockLoanRate(BigDecimal maximumStockLoanRate) {
			this.maximumStockLoanRate = maximumStockLoanRate==null?null:maximumStockLoanRate;
			return this;
		}
		@Override
		@RosettaAttribute("increasedCostOfStockBorrow")
		public StockLoanModel.StockLoanModelBuilder setIncreasedCostOfStockBorrow(Boolean increasedCostOfStockBorrow) {
			this.increasedCostOfStockBorrow = increasedCostOfStockBorrow==null?null:increasedCostOfStockBorrow;
			return this;
		}
		@Override
		@RosettaAttribute("initialStockLoanRate")
		public StockLoanModel.StockLoanModelBuilder setInitialStockLoanRate(BigDecimal initialStockLoanRate) {
			this.initialStockLoanRate = initialStockLoanRate==null?null:initialStockLoanRate;
			return this;
		}
		
		@Override
		public StockLoanModel build() {
			return new StockLoanModel.StockLoanModelImpl(this);
		}
		
		@Override
		public StockLoanModel.StockLoanModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StockLoanModel.StockLoanModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLossOfStockBorrow()!=null) return true;
			if (getMaximumStockLoanRate()!=null) return true;
			if (getIncreasedCostOfStockBorrow()!=null) return true;
			if (getInitialStockLoanRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StockLoanModel.StockLoanModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StockLoanModel.StockLoanModelBuilder o = (StockLoanModel.StockLoanModelBuilder) other;
			
			
			merger.mergeBasic(getLossOfStockBorrow(), o.getLossOfStockBorrow(), this::setLossOfStockBorrow);
			merger.mergeBasic(getMaximumStockLoanRate(), o.getMaximumStockLoanRate(), this::setMaximumStockLoanRate);
			merger.mergeBasic(getIncreasedCostOfStockBorrow(), o.getIncreasedCostOfStockBorrow(), this::setIncreasedCostOfStockBorrow);
			merger.mergeBasic(getInitialStockLoanRate(), o.getInitialStockLoanRate(), this::setInitialStockLoanRate);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StockLoanModel _that = getType().cast(o);
		
			if (!Objects.equals(lossOfStockBorrow, _that.getLossOfStockBorrow())) return false;
			if (!Objects.equals(maximumStockLoanRate, _that.getMaximumStockLoanRate())) return false;
			if (!Objects.equals(increasedCostOfStockBorrow, _that.getIncreasedCostOfStockBorrow())) return false;
			if (!Objects.equals(initialStockLoanRate, _that.getInitialStockLoanRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lossOfStockBorrow != null ? lossOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (maximumStockLoanRate != null ? maximumStockLoanRate.hashCode() : 0);
			_result = 31 * _result + (increasedCostOfStockBorrow != null ? increasedCostOfStockBorrow.hashCode() : 0);
			_result = 31 * _result + (initialStockLoanRate != null ? initialStockLoanRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StockLoanModelBuilder {" +
				"lossOfStockBorrow=" + this.lossOfStockBorrow + ", " +
				"maximumStockLoanRate=" + this.maximumStockLoanRate + ", " +
				"increasedCostOfStockBorrow=" + this.increasedCostOfStockBorrow + ", " +
				"initialStockLoanRate=" + this.initialStockLoanRate +
			'}';
		}
	}
}
