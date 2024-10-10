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
import fpml.confirmation.FxExchangedCurrency;
import fpml.confirmation.FxExchangedCurrencyModel;
import fpml.confirmation.FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder;
import fpml.confirmation.FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilderImpl;
import fpml.confirmation.FxExchangedCurrencyModel.FxExchangedCurrencyModelImpl;
import fpml.confirmation.meta.FxExchangedCurrencyModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indicates the directions of who pays and receives a specific currency without specifying the amount.
 * @version ${project.version}
 */
@RosettaDataType(value="FxExchangedCurrencyModel", builder=FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilderImpl.class, version="${project.version}")
public interface FxExchangedCurrencyModel extends RosettaModelObject {

	FxExchangedCurrencyModelMeta metaData = new FxExchangedCurrencyModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the first direction of who pays and receives a specific currency without specifying the amount.
	 */
	FxExchangedCurrency getExchangedCurrency1();
	/**
	 * Indicates the second direction of who pays and receives a specific currency without specifying the amount.
	 */
	FxExchangedCurrency getExchangedCurrency2();

	/*********************** Build Methods  ***********************/
	FxExchangedCurrencyModel build();
	
	FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder toBuilder();
	
	static FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder builder() {
		return new FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxExchangedCurrencyModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxExchangedCurrencyModel> getType() {
		return FxExchangedCurrencyModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("exchangedCurrency1"), processor, FxExchangedCurrency.class, getExchangedCurrency1());
		processRosetta(path.newSubPath("exchangedCurrency2"), processor, FxExchangedCurrency.class, getExchangedCurrency2());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxExchangedCurrencyModelBuilder extends FxExchangedCurrencyModel, RosettaModelObjectBuilder {
		FxExchangedCurrency.FxExchangedCurrencyBuilder getOrCreateExchangedCurrency1();
		FxExchangedCurrency.FxExchangedCurrencyBuilder getExchangedCurrency1();
		FxExchangedCurrency.FxExchangedCurrencyBuilder getOrCreateExchangedCurrency2();
		FxExchangedCurrency.FxExchangedCurrencyBuilder getExchangedCurrency2();
		FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder setExchangedCurrency1(FxExchangedCurrency exchangedCurrency1);
		FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder setExchangedCurrency2(FxExchangedCurrency exchangedCurrency2);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("exchangedCurrency1"), processor, FxExchangedCurrency.FxExchangedCurrencyBuilder.class, getExchangedCurrency1());
			processRosetta(path.newSubPath("exchangedCurrency2"), processor, FxExchangedCurrency.FxExchangedCurrencyBuilder.class, getExchangedCurrency2());
		}
		

		FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder prune();
	}

	/*********************** Immutable Implementation of FxExchangedCurrencyModel  ***********************/
	class FxExchangedCurrencyModelImpl implements FxExchangedCurrencyModel {
		private final FxExchangedCurrency exchangedCurrency1;
		private final FxExchangedCurrency exchangedCurrency2;
		
		protected FxExchangedCurrencyModelImpl(FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder builder) {
			this.exchangedCurrency1 = ofNullable(builder.getExchangedCurrency1()).map(f->f.build()).orElse(null);
			this.exchangedCurrency2 = ofNullable(builder.getExchangedCurrency2()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency1")
		public FxExchangedCurrency getExchangedCurrency1() {
			return exchangedCurrency1;
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency2")
		public FxExchangedCurrency getExchangedCurrency2() {
			return exchangedCurrency2;
		}
		
		@Override
		public FxExchangedCurrencyModel build() {
			return this;
		}
		
		@Override
		public FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder toBuilder() {
			FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder builder) {
			ofNullable(getExchangedCurrency1()).ifPresent(builder::setExchangedCurrency1);
			ofNullable(getExchangedCurrency2()).ifPresent(builder::setExchangedCurrency2);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxExchangedCurrencyModel _that = getType().cast(o);
		
			if (!Objects.equals(exchangedCurrency1, _that.getExchangedCurrency1())) return false;
			if (!Objects.equals(exchangedCurrency2, _that.getExchangedCurrency2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exchangedCurrency1 != null ? exchangedCurrency1.hashCode() : 0);
			_result = 31 * _result + (exchangedCurrency2 != null ? exchangedCurrency2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExchangedCurrencyModel {" +
				"exchangedCurrency1=" + this.exchangedCurrency1 + ", " +
				"exchangedCurrency2=" + this.exchangedCurrency2 +
			'}';
		}
	}

	/*********************** Builder Implementation of FxExchangedCurrencyModel  ***********************/
	class FxExchangedCurrencyModelBuilderImpl implements FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder {
	
		protected FxExchangedCurrency.FxExchangedCurrencyBuilder exchangedCurrency1;
		protected FxExchangedCurrency.FxExchangedCurrencyBuilder exchangedCurrency2;
	
		public FxExchangedCurrencyModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("exchangedCurrency1")
		public FxExchangedCurrency.FxExchangedCurrencyBuilder getExchangedCurrency1() {
			return exchangedCurrency1;
		}
		
		@Override
		public FxExchangedCurrency.FxExchangedCurrencyBuilder getOrCreateExchangedCurrency1() {
			FxExchangedCurrency.FxExchangedCurrencyBuilder result;
			if (exchangedCurrency1!=null) {
				result = exchangedCurrency1;
			}
			else {
				result = exchangedCurrency1 = FxExchangedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency2")
		public FxExchangedCurrency.FxExchangedCurrencyBuilder getExchangedCurrency2() {
			return exchangedCurrency2;
		}
		
		@Override
		public FxExchangedCurrency.FxExchangedCurrencyBuilder getOrCreateExchangedCurrency2() {
			FxExchangedCurrency.FxExchangedCurrencyBuilder result;
			if (exchangedCurrency2!=null) {
				result = exchangedCurrency2;
			}
			else {
				result = exchangedCurrency2 = FxExchangedCurrency.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangedCurrency1")
		public FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder setExchangedCurrency1(FxExchangedCurrency exchangedCurrency1) {
			this.exchangedCurrency1 = exchangedCurrency1==null?null:exchangedCurrency1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangedCurrency2")
		public FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder setExchangedCurrency2(FxExchangedCurrency exchangedCurrency2) {
			this.exchangedCurrency2 = exchangedCurrency2==null?null:exchangedCurrency2.toBuilder();
			return this;
		}
		
		@Override
		public FxExchangedCurrencyModel build() {
			return new FxExchangedCurrencyModel.FxExchangedCurrencyModelImpl(this);
		}
		
		@Override
		public FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder prune() {
			if (exchangedCurrency1!=null && !exchangedCurrency1.prune().hasData()) exchangedCurrency1 = null;
			if (exchangedCurrency2!=null && !exchangedCurrency2.prune().hasData()) exchangedCurrency2 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExchangedCurrency1()!=null && getExchangedCurrency1().hasData()) return true;
			if (getExchangedCurrency2()!=null && getExchangedCurrency2().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder o = (FxExchangedCurrencyModel.FxExchangedCurrencyModelBuilder) other;
			
			merger.mergeRosetta(getExchangedCurrency1(), o.getExchangedCurrency1(), this::setExchangedCurrency1);
			merger.mergeRosetta(getExchangedCurrency2(), o.getExchangedCurrency2(), this::setExchangedCurrency2);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxExchangedCurrencyModel _that = getType().cast(o);
		
			if (!Objects.equals(exchangedCurrency1, _that.getExchangedCurrency1())) return false;
			if (!Objects.equals(exchangedCurrency2, _that.getExchangedCurrency2())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exchangedCurrency1 != null ? exchangedCurrency1.hashCode() : 0);
			_result = 31 * _result + (exchangedCurrency2 != null ? exchangedCurrency2.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExchangedCurrencyModelBuilder {" +
				"exchangedCurrency1=" + this.exchangedCurrency1 + ", " +
				"exchangedCurrency2=" + this.exchangedCurrency2 +
			'}';
		}
	}
}
