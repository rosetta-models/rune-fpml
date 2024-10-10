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
import fpml.confirmation.CommodityBasketBase;
import fpml.confirmation.CommodityBasketBase.CommodityBasketBaseBuilder;
import fpml.confirmation.CommodityBasketBase.CommodityBasketBaseBuilderImpl;
import fpml.confirmation.CommodityBasketBase.CommodityBasketBaseImpl;
import fpml.confirmation.meta.CommodityBasketBaseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Abstract base class for all underlying assets.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityBasketBase", builder=CommodityBasketBase.CommodityBasketBaseBuilderImpl.class, version="${project.version}")
public interface CommodityBasketBase extends RosettaModelObject {

	CommodityBasketBaseMeta metaData = new CommodityBasketBaseMeta();

	/*********************** Getter Methods  ***********************/
	String getId();

	/*********************** Build Methods  ***********************/
	CommodityBasketBase build();
	
	CommodityBasketBase.CommodityBasketBaseBuilder toBuilder();
	
	static CommodityBasketBase.CommodityBasketBaseBuilder builder() {
		return new CommodityBasketBase.CommodityBasketBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketBase> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBasketBase> getType() {
		return CommodityBasketBase.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketBaseBuilder extends CommodityBasketBase, RosettaModelObjectBuilder {
		CommodityBasketBase.CommodityBasketBaseBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityBasketBase.CommodityBasketBaseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketBase  ***********************/
	class CommodityBasketBaseImpl implements CommodityBasketBase {
		private final String id;
		
		protected CommodityBasketBaseImpl(CommodityBasketBase.CommodityBasketBaseBuilder builder) {
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public CommodityBasketBase build() {
			return this;
		}
		
		@Override
		public CommodityBasketBase.CommodityBasketBaseBuilder toBuilder() {
			CommodityBasketBase.CommodityBasketBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketBase.CommodityBasketBaseBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasketBase _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketBase {" +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityBasketBase  ***********************/
	class CommodityBasketBaseBuilderImpl implements CommodityBasketBase.CommodityBasketBaseBuilder {
	
		protected String id;
	
		public CommodityBasketBaseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("id")
		public CommodityBasketBase.CommodityBasketBaseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CommodityBasketBase build() {
			return new CommodityBasketBase.CommodityBasketBaseImpl(this);
		}
		
		@Override
		public CommodityBasketBase.CommodityBasketBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketBase.CommodityBasketBaseBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketBase.CommodityBasketBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityBasketBase.CommodityBasketBaseBuilder o = (CommodityBasketBase.CommodityBasketBaseBuilder) other;
			
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityBasketBase _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketBaseBuilder {" +
				"id=" + this.id +
			'}';
		}
	}
}
