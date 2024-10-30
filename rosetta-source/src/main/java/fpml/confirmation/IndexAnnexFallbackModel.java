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
import fpml.confirmation.IndexAnnexFallbackModel;
import fpml.confirmation.IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder;
import fpml.confirmation.IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilderImpl;
import fpml.confirmation.IndexAnnexFallbackModel.IndexAnnexFallbackModelImpl;
import fpml.confirmation.meta.IndexAnnexFallbackModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="IndexAnnexFallbackModel", builder=IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface IndexAnnexFallbackModel extends RosettaModelObject {

	IndexAnnexFallbackModelMeta metaData = new IndexAnnexFallbackModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * For an index option transaction, a flag to indicate whether a relevant Multiple Exchange Index Annex is applicable to the transaction. This annex defines additional provisions which are applicable where an index is comprised of component securities that are traded on multiple exchanges.
	 */
	Boolean getMultipleExchangeIndexAnnexFallback();
	/**
	 * For an index option transaction, a flag to indicate whether a relevant Component Security Index Annex is applicable to the transaction.
	 */
	Boolean getComponentSecurityIndexAnnexFallback();

	/*********************** Build Methods  ***********************/
	IndexAnnexFallbackModel build();
	
	IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder toBuilder();
	
	static IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder builder() {
		return new IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexAnnexFallbackModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends IndexAnnexFallbackModel> getType() {
		return IndexAnnexFallbackModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("multipleExchangeIndexAnnexFallback"), Boolean.class, getMultipleExchangeIndexAnnexFallback(), this);
		processor.processBasic(path.newSubPath("componentSecurityIndexAnnexFallback"), Boolean.class, getComponentSecurityIndexAnnexFallback(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexAnnexFallbackModelBuilder extends IndexAnnexFallbackModel, RosettaModelObjectBuilder {
		IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder setMultipleExchangeIndexAnnexFallback(Boolean multipleExchangeIndexAnnexFallback);
		IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder setComponentSecurityIndexAnnexFallback(Boolean componentSecurityIndexAnnexFallback);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("multipleExchangeIndexAnnexFallback"), Boolean.class, getMultipleExchangeIndexAnnexFallback(), this);
			processor.processBasic(path.newSubPath("componentSecurityIndexAnnexFallback"), Boolean.class, getComponentSecurityIndexAnnexFallback(), this);
		}
		

		IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder prune();
	}

	/*********************** Immutable Implementation of IndexAnnexFallbackModel  ***********************/
	class IndexAnnexFallbackModelImpl implements IndexAnnexFallbackModel {
		private final Boolean multipleExchangeIndexAnnexFallback;
		private final Boolean componentSecurityIndexAnnexFallback;
		
		protected IndexAnnexFallbackModelImpl(IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder builder) {
			this.multipleExchangeIndexAnnexFallback = builder.getMultipleExchangeIndexAnnexFallback();
			this.componentSecurityIndexAnnexFallback = builder.getComponentSecurityIndexAnnexFallback();
		}
		
		@Override
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		public Boolean getMultipleExchangeIndexAnnexFallback() {
			return multipleExchangeIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		public Boolean getComponentSecurityIndexAnnexFallback() {
			return componentSecurityIndexAnnexFallback;
		}
		
		@Override
		public IndexAnnexFallbackModel build() {
			return this;
		}
		
		@Override
		public IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder toBuilder() {
			IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder builder) {
			ofNullable(getMultipleExchangeIndexAnnexFallback()).ifPresent(builder::setMultipleExchangeIndexAnnexFallback);
			ofNullable(getComponentSecurityIndexAnnexFallback()).ifPresent(builder::setComponentSecurityIndexAnnexFallback);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexAnnexFallbackModel _that = getType().cast(o);
		
			if (!Objects.equals(multipleExchangeIndexAnnexFallback, _that.getMultipleExchangeIndexAnnexFallback())) return false;
			if (!Objects.equals(componentSecurityIndexAnnexFallback, _that.getComponentSecurityIndexAnnexFallback())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (multipleExchangeIndexAnnexFallback != null ? multipleExchangeIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (componentSecurityIndexAnnexFallback != null ? componentSecurityIndexAnnexFallback.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexAnnexFallbackModel {" +
				"multipleExchangeIndexAnnexFallback=" + this.multipleExchangeIndexAnnexFallback + ", " +
				"componentSecurityIndexAnnexFallback=" + this.componentSecurityIndexAnnexFallback +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexAnnexFallbackModel  ***********************/
	class IndexAnnexFallbackModelBuilderImpl implements IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder {
	
		protected Boolean multipleExchangeIndexAnnexFallback;
		protected Boolean componentSecurityIndexAnnexFallback;
	
		public IndexAnnexFallbackModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		public Boolean getMultipleExchangeIndexAnnexFallback() {
			return multipleExchangeIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		public Boolean getComponentSecurityIndexAnnexFallback() {
			return componentSecurityIndexAnnexFallback;
		}
		
		@Override
		@RosettaAttribute("multipleExchangeIndexAnnexFallback")
		public IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder setMultipleExchangeIndexAnnexFallback(Boolean multipleExchangeIndexAnnexFallback) {
			this.multipleExchangeIndexAnnexFallback = multipleExchangeIndexAnnexFallback==null?null:multipleExchangeIndexAnnexFallback;
			return this;
		}
		@Override
		@RosettaAttribute("componentSecurityIndexAnnexFallback")
		public IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder setComponentSecurityIndexAnnexFallback(Boolean componentSecurityIndexAnnexFallback) {
			this.componentSecurityIndexAnnexFallback = componentSecurityIndexAnnexFallback==null?null:componentSecurityIndexAnnexFallback;
			return this;
		}
		
		@Override
		public IndexAnnexFallbackModel build() {
			return new IndexAnnexFallbackModel.IndexAnnexFallbackModelImpl(this);
		}
		
		@Override
		public IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMultipleExchangeIndexAnnexFallback()!=null) return true;
			if (getComponentSecurityIndexAnnexFallback()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder o = (IndexAnnexFallbackModel.IndexAnnexFallbackModelBuilder) other;
			
			
			merger.mergeBasic(getMultipleExchangeIndexAnnexFallback(), o.getMultipleExchangeIndexAnnexFallback(), this::setMultipleExchangeIndexAnnexFallback);
			merger.mergeBasic(getComponentSecurityIndexAnnexFallback(), o.getComponentSecurityIndexAnnexFallback(), this::setComponentSecurityIndexAnnexFallback);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexAnnexFallbackModel _that = getType().cast(o);
		
			if (!Objects.equals(multipleExchangeIndexAnnexFallback, _that.getMultipleExchangeIndexAnnexFallback())) return false;
			if (!Objects.equals(componentSecurityIndexAnnexFallback, _that.getComponentSecurityIndexAnnexFallback())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (multipleExchangeIndexAnnexFallback != null ? multipleExchangeIndexAnnexFallback.hashCode() : 0);
			_result = 31 * _result + (componentSecurityIndexAnnexFallback != null ? componentSecurityIndexAnnexFallback.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexAnnexFallbackModelBuilder {" +
				"multipleExchangeIndexAnnexFallback=" + this.multipleExchangeIndexAnnexFallback + ", " +
				"componentSecurityIndexAnnexFallback=" + this.componentSecurityIndexAnnexFallback +
			'}';
		}
	}
}
