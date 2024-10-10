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
import fpml.confirmation.CommodityForwardLeg;
import fpml.confirmation.CommodityForwardLeg.CommodityForwardLegBuilder;
import fpml.confirmation.CommodityForwardLeg.CommodityForwardLegBuilderImpl;
import fpml.confirmation.CommodityForwardLeg.CommodityForwardLegImpl;
import fpml.confirmation.Leg;
import fpml.confirmation.Leg.LegBuilder;
import fpml.confirmation.Leg.LegBuilderImpl;
import fpml.confirmation.Leg.LegImpl;
import fpml.confirmation.meta.CommodityForwardLegMeta;


/**
 * Defines the substitutable commodity forward leg. Abstract base class for all commodity forward legs.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityForwardLeg", builder=CommodityForwardLeg.CommodityForwardLegBuilderImpl.class, version="${project.version}")
public interface CommodityForwardLeg extends Leg {

	CommodityForwardLegMeta metaData = new CommodityForwardLegMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	CommodityForwardLeg build();
	
	CommodityForwardLeg.CommodityForwardLegBuilder toBuilder();
	
	static CommodityForwardLeg.CommodityForwardLegBuilder builder() {
		return new CommodityForwardLeg.CommodityForwardLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityForwardLeg> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityForwardLeg> getType() {
		return CommodityForwardLeg.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityForwardLegBuilder extends CommodityForwardLeg, Leg.LegBuilder {
		CommodityForwardLeg.CommodityForwardLegBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		CommodityForwardLeg.CommodityForwardLegBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityForwardLeg  ***********************/
	class CommodityForwardLegImpl extends Leg.LegImpl implements CommodityForwardLeg {
		
		protected CommodityForwardLegImpl(CommodityForwardLeg.CommodityForwardLegBuilder builder) {
			super(builder);
		}
		
		@Override
		public CommodityForwardLeg build() {
			return this;
		}
		
		@Override
		public CommodityForwardLeg.CommodityForwardLegBuilder toBuilder() {
			CommodityForwardLeg.CommodityForwardLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityForwardLeg.CommodityForwardLegBuilder builder) {
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
			return "CommodityForwardLeg {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityForwardLeg  ***********************/
	class CommodityForwardLegBuilderImpl extends Leg.LegBuilderImpl  implements CommodityForwardLeg.CommodityForwardLegBuilder {
	
	
		public CommodityForwardLegBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("id")
		public CommodityForwardLeg.CommodityForwardLegBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public CommodityForwardLeg build() {
			return new CommodityForwardLeg.CommodityForwardLegImpl(this);
		}
		
		@Override
		public CommodityForwardLeg.CommodityForwardLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityForwardLeg.CommodityForwardLegBuilder prune() {
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
		public CommodityForwardLeg.CommodityForwardLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityForwardLeg.CommodityForwardLegBuilder o = (CommodityForwardLeg.CommodityForwardLegBuilder) other;
			
			
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
			return "CommodityForwardLegBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
