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
import fpml.confirmation.UnderlyingAssetTranche;
import fpml.confirmation.UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder;
import fpml.confirmation.UnderlyingAssetTranche.UnderlyingAssetTrancheBuilderImpl;
import fpml.confirmation.UnderlyingAssetTranche.UnderlyingAssetTrancheImpl;
import fpml.confirmation.meta.UnderlyingAssetTrancheMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="UnderlyingAssetTranche", builder=UnderlyingAssetTranche.UnderlyingAssetTrancheBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface UnderlyingAssetTranche extends RosettaModelObject {

	UnderlyingAssetTrancheMeta metaData = new UnderlyingAssetTrancheMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getLoanTrancheScheme();

	/*********************** Build Methods  ***********************/
	UnderlyingAssetTranche build();
	
	UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder toBuilder();
	
	static UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder builder() {
		return new UnderlyingAssetTranche.UnderlyingAssetTrancheBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnderlyingAssetTranche> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends UnderlyingAssetTranche> getType() {
		return UnderlyingAssetTranche.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("loanTrancheScheme"), String.class, getLoanTrancheScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlyingAssetTrancheBuilder extends UnderlyingAssetTranche, RosettaModelObjectBuilder {
		UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder setValue(String value);
		UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder setLoanTrancheScheme(String loanTrancheScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("loanTrancheScheme"), String.class, getLoanTrancheScheme(), this);
		}
		

		UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder prune();
	}

	/*********************** Immutable Implementation of UnderlyingAssetTranche  ***********************/
	class UnderlyingAssetTrancheImpl implements UnderlyingAssetTranche {
		private final String value;
		private final String loanTrancheScheme;
		
		protected UnderlyingAssetTrancheImpl(UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder builder) {
			this.value = builder.getValue();
			this.loanTrancheScheme = builder.getLoanTrancheScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("loanTrancheScheme")
		public String getLoanTrancheScheme() {
			return loanTrancheScheme;
		}
		
		@Override
		public UnderlyingAssetTranche build() {
			return this;
		}
		
		@Override
		public UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder toBuilder() {
			UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLoanTrancheScheme()).ifPresent(builder::setLoanTrancheScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnderlyingAssetTranche _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanTrancheScheme, _that.getLoanTrancheScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanTrancheScheme != null ? loanTrancheScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyingAssetTranche {" +
				"value=" + this.value + ", " +
				"loanTrancheScheme=" + this.loanTrancheScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of UnderlyingAssetTranche  ***********************/
	class UnderlyingAssetTrancheBuilderImpl implements UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder {
	
		protected String value;
		protected String loanTrancheScheme;
	
		public UnderlyingAssetTrancheBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("loanTrancheScheme")
		public String getLoanTrancheScheme() {
			return loanTrancheScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("loanTrancheScheme")
		public UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder setLoanTrancheScheme(String loanTrancheScheme) {
			this.loanTrancheScheme = loanTrancheScheme==null?null:loanTrancheScheme;
			return this;
		}
		
		@Override
		public UnderlyingAssetTranche build() {
			return new UnderlyingAssetTranche.UnderlyingAssetTrancheImpl(this);
		}
		
		@Override
		public UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLoanTrancheScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder o = (UnderlyingAssetTranche.UnderlyingAssetTrancheBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLoanTrancheScheme(), o.getLoanTrancheScheme(), this::setLoanTrancheScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnderlyingAssetTranche _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(loanTrancheScheme, _that.getLoanTrancheScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (loanTrancheScheme != null ? loanTrancheScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyingAssetTrancheBuilder {" +
				"value=" + this.value + ", " +
				"loanTrancheScheme=" + this.loanTrancheScheme +
			'}';
		}
	}
}
