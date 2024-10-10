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
import fpml.confirmation.UnderlyerLoanRate;
import fpml.confirmation.UnderlyerLoanRate.UnderlyerLoanRateBuilder;
import fpml.confirmation.UnderlyerLoanRate.UnderlyerLoanRateBuilderImpl;
import fpml.confirmation.UnderlyerLoanRate.UnderlyerLoanRateImpl;
import fpml.confirmation.meta.UnderlyerLoanRateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines stock loan information where this is required per underlyer. You must not duplicate infromation within dividend conditions at transaction level
 * @version ${project.version}
 */
@RosettaDataType(value="UnderlyerLoanRate", builder=UnderlyerLoanRate.UnderlyerLoanRateBuilderImpl.class, version="${project.version}")
public interface UnderlyerLoanRate extends RosettaModelObject {

	UnderlyerLoanRateMeta metaData = new UnderlyerLoanRateMeta();

	/*********************** Getter Methods  ***********************/
	StockLoanModel getStockLoanModel();

	/*********************** Build Methods  ***********************/
	UnderlyerLoanRate build();
	
	UnderlyerLoanRate.UnderlyerLoanRateBuilder toBuilder();
	
	static UnderlyerLoanRate.UnderlyerLoanRateBuilder builder() {
		return new UnderlyerLoanRate.UnderlyerLoanRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnderlyerLoanRate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UnderlyerLoanRate> getType() {
		return UnderlyerLoanRate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("stockLoanModel"), processor, StockLoanModel.class, getStockLoanModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlyerLoanRateBuilder extends UnderlyerLoanRate, RosettaModelObjectBuilder {
		StockLoanModel.StockLoanModelBuilder getOrCreateStockLoanModel();
		StockLoanModel.StockLoanModelBuilder getStockLoanModel();
		UnderlyerLoanRate.UnderlyerLoanRateBuilder setStockLoanModel(StockLoanModel stockLoanModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("stockLoanModel"), processor, StockLoanModel.StockLoanModelBuilder.class, getStockLoanModel());
		}
		

		UnderlyerLoanRate.UnderlyerLoanRateBuilder prune();
	}

	/*********************** Immutable Implementation of UnderlyerLoanRate  ***********************/
	class UnderlyerLoanRateImpl implements UnderlyerLoanRate {
		private final StockLoanModel stockLoanModel;
		
		protected UnderlyerLoanRateImpl(UnderlyerLoanRate.UnderlyerLoanRateBuilder builder) {
			this.stockLoanModel = ofNullable(builder.getStockLoanModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("stockLoanModel")
		public StockLoanModel getStockLoanModel() {
			return stockLoanModel;
		}
		
		@Override
		public UnderlyerLoanRate build() {
			return this;
		}
		
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder toBuilder() {
			UnderlyerLoanRate.UnderlyerLoanRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnderlyerLoanRate.UnderlyerLoanRateBuilder builder) {
			ofNullable(getStockLoanModel()).ifPresent(builder::setStockLoanModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnderlyerLoanRate _that = getType().cast(o);
		
			if (!Objects.equals(stockLoanModel, _that.getStockLoanModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (stockLoanModel != null ? stockLoanModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyerLoanRate {" +
				"stockLoanModel=" + this.stockLoanModel +
			'}';
		}
	}

	/*********************** Builder Implementation of UnderlyerLoanRate  ***********************/
	class UnderlyerLoanRateBuilderImpl implements UnderlyerLoanRate.UnderlyerLoanRateBuilder {
	
		protected StockLoanModel.StockLoanModelBuilder stockLoanModel;
	
		public UnderlyerLoanRateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("stockLoanModel")
		public StockLoanModel.StockLoanModelBuilder getStockLoanModel() {
			return stockLoanModel;
		}
		
		@Override
		public StockLoanModel.StockLoanModelBuilder getOrCreateStockLoanModel() {
			StockLoanModel.StockLoanModelBuilder result;
			if (stockLoanModel!=null) {
				result = stockLoanModel;
			}
			else {
				result = stockLoanModel = StockLoanModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("stockLoanModel")
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder setStockLoanModel(StockLoanModel stockLoanModel) {
			this.stockLoanModel = stockLoanModel==null?null:stockLoanModel.toBuilder();
			return this;
		}
		
		@Override
		public UnderlyerLoanRate build() {
			return new UnderlyerLoanRate.UnderlyerLoanRateImpl(this);
		}
		
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder prune() {
			if (stockLoanModel!=null && !stockLoanModel.prune().hasData()) stockLoanModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStockLoanModel()!=null && getStockLoanModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyerLoanRate.UnderlyerLoanRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UnderlyerLoanRate.UnderlyerLoanRateBuilder o = (UnderlyerLoanRate.UnderlyerLoanRateBuilder) other;
			
			merger.mergeRosetta(getStockLoanModel(), o.getStockLoanModel(), this::setStockLoanModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnderlyerLoanRate _that = getType().cast(o);
		
			if (!Objects.equals(stockLoanModel, _that.getStockLoanModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (stockLoanModel != null ? stockLoanModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyerLoanRateBuilder {" +
				"stockLoanModel=" + this.stockLoanModel +
			'}';
		}
	}
}
