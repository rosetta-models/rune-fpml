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
import fpml.confirmation.NetAndOrGrossModel;
import fpml.confirmation.NetAndOrGrossModel.NetAndOrGrossModelBuilder;
import fpml.confirmation.NetAndOrGrossModel.NetAndOrGrossModelBuilderImpl;
import fpml.confirmation.NetAndOrGrossModel.NetAndOrGrossModelImpl;
import fpml.confirmation.NetAndOrGrossModelSequence;
import fpml.confirmation.meta.NetAndOrGrossModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group including a net and/or a gross amount.
 * @version ${project.version}
 */
@RosettaDataType(value="NetAndOrGrossModel", builder=NetAndOrGrossModel.NetAndOrGrossModelBuilderImpl.class, version="${project.version}")
public interface NetAndOrGrossModel extends RosettaModelObject {

	NetAndOrGrossModelMeta metaData = new NetAndOrGrossModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Value excluding fees and commissions.
	 */
	BigDecimal getNet();
	NetAndOrGrossModelSequence getNetAndOrGrossModelSequence();

	/*********************** Build Methods  ***********************/
	NetAndOrGrossModel build();
	
	NetAndOrGrossModel.NetAndOrGrossModelBuilder toBuilder();
	
	static NetAndOrGrossModel.NetAndOrGrossModelBuilder builder() {
		return new NetAndOrGrossModel.NetAndOrGrossModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NetAndOrGrossModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NetAndOrGrossModel> getType() {
		return NetAndOrGrossModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("net"), BigDecimal.class, getNet(), this);
		processRosetta(path.newSubPath("netAndOrGrossModelSequence"), processor, NetAndOrGrossModelSequence.class, getNetAndOrGrossModelSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NetAndOrGrossModelBuilder extends NetAndOrGrossModel, RosettaModelObjectBuilder {
		NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder getOrCreateNetAndOrGrossModelSequence();
		NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder getNetAndOrGrossModelSequence();
		NetAndOrGrossModel.NetAndOrGrossModelBuilder setNet(BigDecimal net);
		NetAndOrGrossModel.NetAndOrGrossModelBuilder setNetAndOrGrossModelSequence(NetAndOrGrossModelSequence netAndOrGrossModelSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("net"), BigDecimal.class, getNet(), this);
			processRosetta(path.newSubPath("netAndOrGrossModelSequence"), processor, NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder.class, getNetAndOrGrossModelSequence());
		}
		

		NetAndOrGrossModel.NetAndOrGrossModelBuilder prune();
	}

	/*********************** Immutable Implementation of NetAndOrGrossModel  ***********************/
	class NetAndOrGrossModelImpl implements NetAndOrGrossModel {
		private final BigDecimal net;
		private final NetAndOrGrossModelSequence netAndOrGrossModelSequence;
		
		protected NetAndOrGrossModelImpl(NetAndOrGrossModel.NetAndOrGrossModelBuilder builder) {
			this.net = builder.getNet();
			this.netAndOrGrossModelSequence = ofNullable(builder.getNetAndOrGrossModelSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("net")
		public BigDecimal getNet() {
			return net;
		}
		
		@Override
		@RosettaAttribute("netAndOrGrossModelSequence")
		public NetAndOrGrossModelSequence getNetAndOrGrossModelSequence() {
			return netAndOrGrossModelSequence;
		}
		
		@Override
		public NetAndOrGrossModel build() {
			return this;
		}
		
		@Override
		public NetAndOrGrossModel.NetAndOrGrossModelBuilder toBuilder() {
			NetAndOrGrossModel.NetAndOrGrossModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NetAndOrGrossModel.NetAndOrGrossModelBuilder builder) {
			ofNullable(getNet()).ifPresent(builder::setNet);
			ofNullable(getNetAndOrGrossModelSequence()).ifPresent(builder::setNetAndOrGrossModelSequence);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NetAndOrGrossModel _that = getType().cast(o);
		
			if (!Objects.equals(net, _that.getNet())) return false;
			if (!Objects.equals(netAndOrGrossModelSequence, _that.getNetAndOrGrossModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (net != null ? net.hashCode() : 0);
			_result = 31 * _result + (netAndOrGrossModelSequence != null ? netAndOrGrossModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NetAndOrGrossModel {" +
				"net=" + this.net + ", " +
				"netAndOrGrossModelSequence=" + this.netAndOrGrossModelSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of NetAndOrGrossModel  ***********************/
	class NetAndOrGrossModelBuilderImpl implements NetAndOrGrossModel.NetAndOrGrossModelBuilder {
	
		protected BigDecimal net;
		protected NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder netAndOrGrossModelSequence;
	
		public NetAndOrGrossModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("net")
		public BigDecimal getNet() {
			return net;
		}
		
		@Override
		@RosettaAttribute("netAndOrGrossModelSequence")
		public NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder getNetAndOrGrossModelSequence() {
			return netAndOrGrossModelSequence;
		}
		
		@Override
		public NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder getOrCreateNetAndOrGrossModelSequence() {
			NetAndOrGrossModelSequence.NetAndOrGrossModelSequenceBuilder result;
			if (netAndOrGrossModelSequence!=null) {
				result = netAndOrGrossModelSequence;
			}
			else {
				result = netAndOrGrossModelSequence = NetAndOrGrossModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("net")
		public NetAndOrGrossModel.NetAndOrGrossModelBuilder setNet(BigDecimal net) {
			this.net = net==null?null:net;
			return this;
		}
		@Override
		@RosettaAttribute("netAndOrGrossModelSequence")
		public NetAndOrGrossModel.NetAndOrGrossModelBuilder setNetAndOrGrossModelSequence(NetAndOrGrossModelSequence netAndOrGrossModelSequence) {
			this.netAndOrGrossModelSequence = netAndOrGrossModelSequence==null?null:netAndOrGrossModelSequence.toBuilder();
			return this;
		}
		
		@Override
		public NetAndOrGrossModel build() {
			return new NetAndOrGrossModel.NetAndOrGrossModelImpl(this);
		}
		
		@Override
		public NetAndOrGrossModel.NetAndOrGrossModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NetAndOrGrossModel.NetAndOrGrossModelBuilder prune() {
			if (netAndOrGrossModelSequence!=null && !netAndOrGrossModelSequence.prune().hasData()) netAndOrGrossModelSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNet()!=null) return true;
			if (getNetAndOrGrossModelSequence()!=null && getNetAndOrGrossModelSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NetAndOrGrossModel.NetAndOrGrossModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NetAndOrGrossModel.NetAndOrGrossModelBuilder o = (NetAndOrGrossModel.NetAndOrGrossModelBuilder) other;
			
			merger.mergeRosetta(getNetAndOrGrossModelSequence(), o.getNetAndOrGrossModelSequence(), this::setNetAndOrGrossModelSequence);
			
			merger.mergeBasic(getNet(), o.getNet(), this::setNet);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NetAndOrGrossModel _that = getType().cast(o);
		
			if (!Objects.equals(net, _that.getNet())) return false;
			if (!Objects.equals(netAndOrGrossModelSequence, _that.getNetAndOrGrossModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (net != null ? net.hashCode() : 0);
			_result = 31 * _result + (netAndOrGrossModelSequence != null ? netAndOrGrossModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NetAndOrGrossModelBuilder {" +
				"net=" + this.net + ", " +
				"netAndOrGrossModelSequence=" + this.netAndOrGrossModelSequence +
			'}';
		}
	}
}
