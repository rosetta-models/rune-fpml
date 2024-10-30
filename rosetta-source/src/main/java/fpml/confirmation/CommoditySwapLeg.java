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
import fpml.confirmation.CommoditySwapLeg;
import fpml.confirmation.CommoditySwapLeg.CommoditySwapLegBuilder;
import fpml.confirmation.CommoditySwapLeg.CommoditySwapLegBuilderImpl;
import fpml.confirmation.CommoditySwapLeg.CommoditySwapLegImpl;
import fpml.confirmation.Leg;
import fpml.confirmation.Leg.LegBuilder;
import fpml.confirmation.Leg.LegBuilderImpl;
import fpml.confirmation.Leg.LegImpl;
import fpml.confirmation.meta.CommoditySwapLegMeta;


/**
 * Defines the substitutable commodity swap leg Abstract base class for all commodity swap legs
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommoditySwapLeg", builder=CommoditySwapLeg.CommoditySwapLegBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommoditySwapLeg extends Leg {

	CommoditySwapLegMeta metaData = new CommoditySwapLegMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CommoditySwapLeg build();
	
	CommoditySwapLeg.CommoditySwapLegBuilder toBuilder();
	
	static CommoditySwapLeg.CommoditySwapLegBuilder builder() {
		return new CommoditySwapLeg.CommoditySwapLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommoditySwapLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommoditySwapLeg> getType() {
		return CommoditySwapLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommoditySwapLegBuilder extends CommoditySwapLeg, Leg.LegBuilder {
		CommoditySwapLeg.CommoditySwapLegBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommoditySwapLeg.CommoditySwapLegBuilder prune();
	}

	/*********************** Immutable Implementation of CommoditySwapLeg  ***********************/
	class CommoditySwapLegImpl extends Leg.LegImpl implements CommoditySwapLeg {
		
		protected CommoditySwapLegImpl(CommoditySwapLeg.CommoditySwapLegBuilder builder) {
			super(builder);
		}
		
		@Override
		public CommoditySwapLeg build() {
			return this;
		}
		
		@Override
		public CommoditySwapLeg.CommoditySwapLegBuilder toBuilder() {
			CommoditySwapLeg.CommoditySwapLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommoditySwapLeg.CommoditySwapLegBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
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
			return "CommoditySwapLeg {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommoditySwapLeg  ***********************/
	class CommoditySwapLegBuilderImpl extends Leg.LegBuilderImpl  implements CommoditySwapLeg.CommoditySwapLegBuilder {
	
	
		public CommoditySwapLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public CommoditySwapLeg.CommoditySwapLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CommoditySwapLeg build() {
			return new CommoditySwapLeg.CommoditySwapLegImpl(this);
		}
		
		@Override
		public CommoditySwapLeg.CommoditySwapLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommoditySwapLeg.CommoditySwapLegBuilder prune() {
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
		public CommoditySwapLeg.CommoditySwapLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommoditySwapLeg.CommoditySwapLegBuilder o = (CommoditySwapLeg.CommoditySwapLegBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
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
			return "CommoditySwapLegBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
