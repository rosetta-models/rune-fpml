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
import fpml.confirmation.NetAndGross;
import fpml.confirmation.NetAndGross.NetAndGrossBuilder;
import fpml.confirmation.NetAndGross.NetAndGrossBuilderImpl;
import fpml.confirmation.NetAndGross.NetAndGrossImpl;
import fpml.confirmation.NetAndOrGrossModel;
import fpml.confirmation.meta.NetAndGrossMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure including a net and/or a gross amount and possibly fees and commissions.
 * @version ${project.version}
 */
@RosettaDataType(value="NetAndGross", builder=NetAndGross.NetAndGrossBuilderImpl.class, version="${project.version}")
public interface NetAndGross extends RosettaModelObject {

	NetAndGrossMeta metaData = new NetAndGrossMeta();

	/*********************** Getter Methods  ***********************/
	NetAndOrGrossModel getNetAndOrGrossModel();

	/*********************** Build Methods  ***********************/
	NetAndGross build();
	
	NetAndGross.NetAndGrossBuilder toBuilder();
	
	static NetAndGross.NetAndGrossBuilder builder() {
		return new NetAndGross.NetAndGrossBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NetAndGross> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NetAndGross> getType() {
		return NetAndGross.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("netAndOrGrossModel"), processor, NetAndOrGrossModel.class, getNetAndOrGrossModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NetAndGrossBuilder extends NetAndGross, RosettaModelObjectBuilder {
		NetAndOrGrossModel.NetAndOrGrossModelBuilder getOrCreateNetAndOrGrossModel();
		NetAndOrGrossModel.NetAndOrGrossModelBuilder getNetAndOrGrossModel();
		NetAndGross.NetAndGrossBuilder setNetAndOrGrossModel(NetAndOrGrossModel netAndOrGrossModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("netAndOrGrossModel"), processor, NetAndOrGrossModel.NetAndOrGrossModelBuilder.class, getNetAndOrGrossModel());
		}
		

		NetAndGross.NetAndGrossBuilder prune();
	}

	/*********************** Immutable Implementation of NetAndGross  ***********************/
	class NetAndGrossImpl implements NetAndGross {
		private final NetAndOrGrossModel netAndOrGrossModel;
		
		protected NetAndGrossImpl(NetAndGross.NetAndGrossBuilder builder) {
			this.netAndOrGrossModel = ofNullable(builder.getNetAndOrGrossModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("netAndOrGrossModel")
		public NetAndOrGrossModel getNetAndOrGrossModel() {
			return netAndOrGrossModel;
		}
		
		@Override
		public NetAndGross build() {
			return this;
		}
		
		@Override
		public NetAndGross.NetAndGrossBuilder toBuilder() {
			NetAndGross.NetAndGrossBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NetAndGross.NetAndGrossBuilder builder) {
			ofNullable(getNetAndOrGrossModel()).ifPresent(builder::setNetAndOrGrossModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NetAndGross _that = getType().cast(o);
		
			if (!Objects.equals(netAndOrGrossModel, _that.getNetAndOrGrossModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (netAndOrGrossModel != null ? netAndOrGrossModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NetAndGross {" +
				"netAndOrGrossModel=" + this.netAndOrGrossModel +
			'}';
		}
	}

	/*********************** Builder Implementation of NetAndGross  ***********************/
	class NetAndGrossBuilderImpl implements NetAndGross.NetAndGrossBuilder {
	
		protected NetAndOrGrossModel.NetAndOrGrossModelBuilder netAndOrGrossModel;
	
		public NetAndGrossBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("netAndOrGrossModel")
		public NetAndOrGrossModel.NetAndOrGrossModelBuilder getNetAndOrGrossModel() {
			return netAndOrGrossModel;
		}
		
		@Override
		public NetAndOrGrossModel.NetAndOrGrossModelBuilder getOrCreateNetAndOrGrossModel() {
			NetAndOrGrossModel.NetAndOrGrossModelBuilder result;
			if (netAndOrGrossModel!=null) {
				result = netAndOrGrossModel;
			}
			else {
				result = netAndOrGrossModel = NetAndOrGrossModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("netAndOrGrossModel")
		public NetAndGross.NetAndGrossBuilder setNetAndOrGrossModel(NetAndOrGrossModel netAndOrGrossModel) {
			this.netAndOrGrossModel = netAndOrGrossModel==null?null:netAndOrGrossModel.toBuilder();
			return this;
		}
		
		@Override
		public NetAndGross build() {
			return new NetAndGross.NetAndGrossImpl(this);
		}
		
		@Override
		public NetAndGross.NetAndGrossBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NetAndGross.NetAndGrossBuilder prune() {
			if (netAndOrGrossModel!=null && !netAndOrGrossModel.prune().hasData()) netAndOrGrossModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNetAndOrGrossModel()!=null && getNetAndOrGrossModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NetAndGross.NetAndGrossBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NetAndGross.NetAndGrossBuilder o = (NetAndGross.NetAndGrossBuilder) other;
			
			merger.mergeRosetta(getNetAndOrGrossModel(), o.getNetAndOrGrossModel(), this::setNetAndOrGrossModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NetAndGross _that = getType().cast(o);
		
			if (!Objects.equals(netAndOrGrossModel, _that.getNetAndOrGrossModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (netAndOrGrossModel != null ? netAndOrGrossModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NetAndGrossBuilder {" +
				"netAndOrGrossModel=" + this.netAndOrGrossModel +
			'}';
		}
	}
}
