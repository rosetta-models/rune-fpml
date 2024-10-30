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
import fpml.confirmation.DividendConditions;
import fpml.confirmation.Return;
import fpml.confirmation.Return.ReturnBuilder;
import fpml.confirmation.Return.ReturnBuilderImpl;
import fpml.confirmation.Return.ReturnImpl;
import fpml.confirmation.ReturnTypeEnum;
import fpml.confirmation.meta.ReturnMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the dividend return conditions applicable to the swap.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="Return", builder=Return.ReturnBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface Return extends RosettaModelObject {

	ReturnMeta metaData = new ReturnMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the type of return associated with the return swap.
	 */
	ReturnTypeEnum getReturnType();
	/**
	 * Specifies the conditions governing the payment of the dividends to the receiver of the equity return. With the exception of the dividend payout ratio, which is defined for each of the underlying components.
	 */
	DividendConditions getDividendConditions();

	/*********************** Build Methods  ***********************/
	Return build();
	
	Return.ReturnBuilder toBuilder();
	
	static Return.ReturnBuilder builder() {
		return new Return.ReturnBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Return> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Return> getType() {
		return Return.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("returnType"), ReturnTypeEnum.class, getReturnType(), this);
		processRosetta(path.newSubPath("dividendConditions"), processor, DividendConditions.class, getDividendConditions());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReturnBuilder extends Return, RosettaModelObjectBuilder {
		DividendConditions.DividendConditionsBuilder getOrCreateDividendConditions();
		DividendConditions.DividendConditionsBuilder getDividendConditions();
		Return.ReturnBuilder setReturnType(ReturnTypeEnum returnType);
		Return.ReturnBuilder setDividendConditions(DividendConditions dividendConditions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("returnType"), ReturnTypeEnum.class, getReturnType(), this);
			processRosetta(path.newSubPath("dividendConditions"), processor, DividendConditions.DividendConditionsBuilder.class, getDividendConditions());
		}
		

		Return.ReturnBuilder prune();
	}

	/*********************** Immutable Implementation of Return  ***********************/
	class ReturnImpl implements Return {
		private final ReturnTypeEnum returnType;
		private final DividendConditions dividendConditions;
		
		protected ReturnImpl(Return.ReturnBuilder builder) {
			this.returnType = builder.getReturnType();
			this.dividendConditions = ofNullable(builder.getDividendConditions()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("returnType")
		public ReturnTypeEnum getReturnType() {
			return returnType;
		}
		
		@Override
		@RosettaAttribute("dividendConditions")
		public DividendConditions getDividendConditions() {
			return dividendConditions;
		}
		
		@Override
		public Return build() {
			return this;
		}
		
		@Override
		public Return.ReturnBuilder toBuilder() {
			Return.ReturnBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Return.ReturnBuilder builder) {
			ofNullable(getReturnType()).ifPresent(builder::setReturnType);
			ofNullable(getDividendConditions()).ifPresent(builder::setDividendConditions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Return _that = getType().cast(o);
		
			if (!Objects.equals(returnType, _that.getReturnType())) return false;
			if (!Objects.equals(dividendConditions, _that.getDividendConditions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnType != null ? returnType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendConditions != null ? dividendConditions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Return {" +
				"returnType=" + this.returnType + ", " +
				"dividendConditions=" + this.dividendConditions +
			'}';
		}
	}

	/*********************** Builder Implementation of Return  ***********************/
	class ReturnBuilderImpl implements Return.ReturnBuilder {
	
		protected ReturnTypeEnum returnType;
		protected DividendConditions.DividendConditionsBuilder dividendConditions;
	
		public ReturnBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("returnType")
		public ReturnTypeEnum getReturnType() {
			return returnType;
		}
		
		@Override
		@RosettaAttribute("dividendConditions")
		public DividendConditions.DividendConditionsBuilder getDividendConditions() {
			return dividendConditions;
		}
		
		@Override
		public DividendConditions.DividendConditionsBuilder getOrCreateDividendConditions() {
			DividendConditions.DividendConditionsBuilder result;
			if (dividendConditions!=null) {
				result = dividendConditions;
			}
			else {
				result = dividendConditions = DividendConditions.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("returnType")
		public Return.ReturnBuilder setReturnType(ReturnTypeEnum returnType) {
			this.returnType = returnType==null?null:returnType;
			return this;
		}
		@Override
		@RosettaAttribute("dividendConditions")
		public Return.ReturnBuilder setDividendConditions(DividendConditions dividendConditions) {
			this.dividendConditions = dividendConditions==null?null:dividendConditions.toBuilder();
			return this;
		}
		
		@Override
		public Return build() {
			return new Return.ReturnImpl(this);
		}
		
		@Override
		public Return.ReturnBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Return.ReturnBuilder prune() {
			if (dividendConditions!=null && !dividendConditions.prune().hasData()) dividendConditions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getReturnType()!=null) return true;
			if (getDividendConditions()!=null && getDividendConditions().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Return.ReturnBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Return.ReturnBuilder o = (Return.ReturnBuilder) other;
			
			merger.mergeRosetta(getDividendConditions(), o.getDividendConditions(), this::setDividendConditions);
			
			merger.mergeBasic(getReturnType(), o.getReturnType(), this::setReturnType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Return _that = getType().cast(o);
		
			if (!Objects.equals(returnType, _that.getReturnType())) return false;
			if (!Objects.equals(dividendConditions, _that.getDividendConditions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (returnType != null ? returnType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (dividendConditions != null ? dividendConditions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReturnBuilder {" +
				"returnType=" + this.returnType + ", " +
				"dividendConditions=" + this.dividendConditions +
			'}';
		}
	}
}
