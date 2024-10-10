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
import fpml.confirmation.Asset;
import fpml.confirmation.Asset.AssetBuilder;
import fpml.confirmation.Asset.AssetBuilderImpl;
import fpml.confirmation.Asset.AssetImpl;
import fpml.confirmation.CurveInstrument;
import fpml.confirmation.CurveInstrument.CurveInstrumentBuilder;
import fpml.confirmation.CurveInstrument.CurveInstrumentBuilderImpl;
import fpml.confirmation.CurveInstrument.CurveInstrumentImpl;
import fpml.confirmation.meta.CurveInstrumentMeta;


/**
 * Defines the underlying asset when it is a curve instrument.
 * @version ${project.version}
 */
@RosettaDataType(value="CurveInstrument", builder=CurveInstrument.CurveInstrumentBuilderImpl.class, version="${project.version}")
public interface CurveInstrument extends Asset {

	CurveInstrumentMeta metaData = new CurveInstrumentMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CurveInstrument build();
	
	CurveInstrument.CurveInstrumentBuilder toBuilder();
	
	static CurveInstrument.CurveInstrumentBuilder builder() {
		return new CurveInstrument.CurveInstrumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CurveInstrument> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CurveInstrument> getType() {
		return CurveInstrument.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CurveInstrumentBuilder extends CurveInstrument, Asset.AssetBuilder {
		CurveInstrument.CurveInstrumentBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CurveInstrument.CurveInstrumentBuilder prune();
	}

	/*********************** Immutable Implementation of CurveInstrument  ***********************/
	class CurveInstrumentImpl extends Asset.AssetImpl implements CurveInstrument {
		
		protected CurveInstrumentImpl(CurveInstrument.CurveInstrumentBuilder builder) {
			super(builder);
		}
		
		@Override
		public CurveInstrument build() {
			return this;
		}
		
		@Override
		public CurveInstrument.CurveInstrumentBuilder toBuilder() {
			CurveInstrument.CurveInstrumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CurveInstrument.CurveInstrumentBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurveInstrument {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CurveInstrument  ***********************/
	class CurveInstrumentBuilderImpl extends Asset.AssetBuilderImpl  implements CurveInstrument.CurveInstrumentBuilder {
	
	
		public CurveInstrumentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public CurveInstrument.CurveInstrumentBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CurveInstrument build() {
			return new CurveInstrument.CurveInstrumentImpl(this);
		}
		
		@Override
		public CurveInstrument.CurveInstrumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CurveInstrument.CurveInstrumentBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CurveInstrument.CurveInstrumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CurveInstrument.CurveInstrumentBuilder o = (CurveInstrument.CurveInstrumentBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurveInstrumentBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
