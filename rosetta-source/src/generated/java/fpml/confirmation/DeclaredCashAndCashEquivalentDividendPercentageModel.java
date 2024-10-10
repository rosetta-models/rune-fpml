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
import fpml.confirmation.DeclaredCashAndCashEquivalentDividendPercentageModel;
import fpml.confirmation.DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder;
import fpml.confirmation.DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilderImpl;
import fpml.confirmation.DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelImpl;
import fpml.confirmation.meta.DeclaredCashAndCashEquivalentDividendPercentageModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DeclaredCashAndCashEquivalentDividendPercentageModel", builder=DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilderImpl.class, version="${project.version}")
public interface DeclaredCashAndCashEquivalentDividendPercentageModel extends RosettaModelObject {

	DeclaredCashAndCashEquivalentDividendPercentageModelMeta metaData = new DeclaredCashAndCashEquivalentDividendPercentageModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Declared Cash Dividend Percentage.
	 */
	BigDecimal getDeclaredCashDividendPercentage();
	/**
	 * Declared Cash Equivalent Dividend Percentage.
	 */
	BigDecimal getDeclaredCashEquivalentDividendPercentage();

	/*********************** Build Methods  ***********************/
	DeclaredCashAndCashEquivalentDividendPercentageModel build();
	
	DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder toBuilder();
	
	static DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder builder() {
		return new DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DeclaredCashAndCashEquivalentDividendPercentageModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DeclaredCashAndCashEquivalentDividendPercentageModel> getType() {
		return DeclaredCashAndCashEquivalentDividendPercentageModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("declaredCashDividendPercentage"), BigDecimal.class, getDeclaredCashDividendPercentage(), this);
		processor.processBasic(path.newSubPath("declaredCashEquivalentDividendPercentage"), BigDecimal.class, getDeclaredCashEquivalentDividendPercentage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DeclaredCashAndCashEquivalentDividendPercentageModelBuilder extends DeclaredCashAndCashEquivalentDividendPercentageModel, RosettaModelObjectBuilder {
		DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder setDeclaredCashDividendPercentage(BigDecimal declaredCashDividendPercentage);
		DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder setDeclaredCashEquivalentDividendPercentage(BigDecimal declaredCashEquivalentDividendPercentage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("declaredCashDividendPercentage"), BigDecimal.class, getDeclaredCashDividendPercentage(), this);
			processor.processBasic(path.newSubPath("declaredCashEquivalentDividendPercentage"), BigDecimal.class, getDeclaredCashEquivalentDividendPercentage(), this);
		}
		

		DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder prune();
	}

	/*********************** Immutable Implementation of DeclaredCashAndCashEquivalentDividendPercentageModel  ***********************/
	class DeclaredCashAndCashEquivalentDividendPercentageModelImpl implements DeclaredCashAndCashEquivalentDividendPercentageModel {
		private final BigDecimal declaredCashDividendPercentage;
		private final BigDecimal declaredCashEquivalentDividendPercentage;
		
		protected DeclaredCashAndCashEquivalentDividendPercentageModelImpl(DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder builder) {
			this.declaredCashDividendPercentage = builder.getDeclaredCashDividendPercentage();
			this.declaredCashEquivalentDividendPercentage = builder.getDeclaredCashEquivalentDividendPercentage();
		}
		
		@Override
		@RosettaAttribute("declaredCashDividendPercentage")
		public BigDecimal getDeclaredCashDividendPercentage() {
			return declaredCashDividendPercentage;
		}
		
		@Override
		@RosettaAttribute("declaredCashEquivalentDividendPercentage")
		public BigDecimal getDeclaredCashEquivalentDividendPercentage() {
			return declaredCashEquivalentDividendPercentage;
		}
		
		@Override
		public DeclaredCashAndCashEquivalentDividendPercentageModel build() {
			return this;
		}
		
		@Override
		public DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder toBuilder() {
			DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder builder) {
			ofNullable(getDeclaredCashDividendPercentage()).ifPresent(builder::setDeclaredCashDividendPercentage);
			ofNullable(getDeclaredCashEquivalentDividendPercentage()).ifPresent(builder::setDeclaredCashEquivalentDividendPercentage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeclaredCashAndCashEquivalentDividendPercentageModel _that = getType().cast(o);
		
			if (!Objects.equals(declaredCashDividendPercentage, _that.getDeclaredCashDividendPercentage())) return false;
			if (!Objects.equals(declaredCashEquivalentDividendPercentage, _that.getDeclaredCashEquivalentDividendPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (declaredCashDividendPercentage != null ? declaredCashDividendPercentage.hashCode() : 0);
			_result = 31 * _result + (declaredCashEquivalentDividendPercentage != null ? declaredCashEquivalentDividendPercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeclaredCashAndCashEquivalentDividendPercentageModel {" +
				"declaredCashDividendPercentage=" + this.declaredCashDividendPercentage + ", " +
				"declaredCashEquivalentDividendPercentage=" + this.declaredCashEquivalentDividendPercentage +
			'}';
		}
	}

	/*********************** Builder Implementation of DeclaredCashAndCashEquivalentDividendPercentageModel  ***********************/
	class DeclaredCashAndCashEquivalentDividendPercentageModelBuilderImpl implements DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder {
	
		protected BigDecimal declaredCashDividendPercentage;
		protected BigDecimal declaredCashEquivalentDividendPercentage;
	
		public DeclaredCashAndCashEquivalentDividendPercentageModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("declaredCashDividendPercentage")
		public BigDecimal getDeclaredCashDividendPercentage() {
			return declaredCashDividendPercentage;
		}
		
		@Override
		@RosettaAttribute("declaredCashEquivalentDividendPercentage")
		public BigDecimal getDeclaredCashEquivalentDividendPercentage() {
			return declaredCashEquivalentDividendPercentage;
		}
		
		@Override
		@RosettaAttribute("declaredCashDividendPercentage")
		public DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder setDeclaredCashDividendPercentage(BigDecimal declaredCashDividendPercentage) {
			this.declaredCashDividendPercentage = declaredCashDividendPercentage==null?null:declaredCashDividendPercentage;
			return this;
		}
		@Override
		@RosettaAttribute("declaredCashEquivalentDividendPercentage")
		public DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder setDeclaredCashEquivalentDividendPercentage(BigDecimal declaredCashEquivalentDividendPercentage) {
			this.declaredCashEquivalentDividendPercentage = declaredCashEquivalentDividendPercentage==null?null:declaredCashEquivalentDividendPercentage;
			return this;
		}
		
		@Override
		public DeclaredCashAndCashEquivalentDividendPercentageModel build() {
			return new DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelImpl(this);
		}
		
		@Override
		public DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDeclaredCashDividendPercentage()!=null) return true;
			if (getDeclaredCashEquivalentDividendPercentage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder o = (DeclaredCashAndCashEquivalentDividendPercentageModel.DeclaredCashAndCashEquivalentDividendPercentageModelBuilder) other;
			
			
			merger.mergeBasic(getDeclaredCashDividendPercentage(), o.getDeclaredCashDividendPercentage(), this::setDeclaredCashDividendPercentage);
			merger.mergeBasic(getDeclaredCashEquivalentDividendPercentage(), o.getDeclaredCashEquivalentDividendPercentage(), this::setDeclaredCashEquivalentDividendPercentage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeclaredCashAndCashEquivalentDividendPercentageModel _that = getType().cast(o);
		
			if (!Objects.equals(declaredCashDividendPercentage, _that.getDeclaredCashDividendPercentage())) return false;
			if (!Objects.equals(declaredCashEquivalentDividendPercentage, _that.getDeclaredCashEquivalentDividendPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (declaredCashDividendPercentage != null ? declaredCashDividendPercentage.hashCode() : 0);
			_result = 31 * _result + (declaredCashEquivalentDividendPercentage != null ? declaredCashEquivalentDividendPercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeclaredCashAndCashEquivalentDividendPercentageModelBuilder {" +
				"declaredCashDividendPercentage=" + this.declaredCashDividendPercentage + ", " +
				"declaredCashEquivalentDividendPercentage=" + this.declaredCashEquivalentDividendPercentage +
			'}';
		}
	}
}
