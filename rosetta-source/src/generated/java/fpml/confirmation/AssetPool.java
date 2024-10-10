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
import fpml.confirmation.AssetPool;
import fpml.confirmation.AssetPool.AssetPoolBuilder;
import fpml.confirmation.AssetPool.AssetPoolBuilderImpl;
import fpml.confirmation.AssetPool.AssetPoolImpl;
import fpml.confirmation.VersionHistoryModel;
import fpml.confirmation.meta.AssetPoolMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Characterise the asset pool behind an asset backed bond.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetPool", builder=AssetPool.AssetPoolBuilderImpl.class, version="${project.version}")
public interface AssetPool extends RosettaModelObject {

	AssetPoolMeta metaData = new AssetPoolMeta();

	/*********************** Getter Methods  ***********************/
	VersionHistoryModel getVersionHistoryModel();
	/**
	 * The part of the mortgage that is outstanding on trade inception, i.e. has not been repaid yet as principal. It is expressed as a multiplier factor to the morgage: 1 means that the whole mortage amount is outstanding, 0.8 means that 20% has been repaid.
	 */
	BigDecimal getInitialFactor();
	/**
	 * The part of the mortgage that is currently outstanding. It is expressed similarly to the initial factor, as factor multiplier to the mortgage. This term is formally defined as part of the &quot;ISDA Standard Terms Supplement for use with credit derivatives transactions on mortgage-backed security with pas-as-you-go or physical settlement&quot;.
	 */
	BigDecimal getCurrentFactor();

	/*********************** Build Methods  ***********************/
	AssetPool build();
	
	AssetPool.AssetPoolBuilder toBuilder();
	
	static AssetPool.AssetPoolBuilder builder() {
		return new AssetPool.AssetPoolBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetPool> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AssetPool> getType() {
		return AssetPool.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("versionHistoryModel"), processor, VersionHistoryModel.class, getVersionHistoryModel());
		processor.processBasic(path.newSubPath("initialFactor"), BigDecimal.class, getInitialFactor(), this);
		processor.processBasic(path.newSubPath("currentFactor"), BigDecimal.class, getCurrentFactor(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetPoolBuilder extends AssetPool, RosettaModelObjectBuilder {
		VersionHistoryModel.VersionHistoryModelBuilder getOrCreateVersionHistoryModel();
		VersionHistoryModel.VersionHistoryModelBuilder getVersionHistoryModel();
		AssetPool.AssetPoolBuilder setVersionHistoryModel(VersionHistoryModel versionHistoryModel);
		AssetPool.AssetPoolBuilder setInitialFactor(BigDecimal initialFactor);
		AssetPool.AssetPoolBuilder setCurrentFactor(BigDecimal currentFactor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("versionHistoryModel"), processor, VersionHistoryModel.VersionHistoryModelBuilder.class, getVersionHistoryModel());
			processor.processBasic(path.newSubPath("initialFactor"), BigDecimal.class, getInitialFactor(), this);
			processor.processBasic(path.newSubPath("currentFactor"), BigDecimal.class, getCurrentFactor(), this);
		}
		

		AssetPool.AssetPoolBuilder prune();
	}

	/*********************** Immutable Implementation of AssetPool  ***********************/
	class AssetPoolImpl implements AssetPool {
		private final VersionHistoryModel versionHistoryModel;
		private final BigDecimal initialFactor;
		private final BigDecimal currentFactor;
		
		protected AssetPoolImpl(AssetPool.AssetPoolBuilder builder) {
			this.versionHistoryModel = ofNullable(builder.getVersionHistoryModel()).map(f->f.build()).orElse(null);
			this.initialFactor = builder.getInitialFactor();
			this.currentFactor = builder.getCurrentFactor();
		}
		
		@Override
		@RosettaAttribute("versionHistoryModel")
		public VersionHistoryModel getVersionHistoryModel() {
			return versionHistoryModel;
		}
		
		@Override
		@RosettaAttribute("initialFactor")
		public BigDecimal getInitialFactor() {
			return initialFactor;
		}
		
		@Override
		@RosettaAttribute("currentFactor")
		public BigDecimal getCurrentFactor() {
			return currentFactor;
		}
		
		@Override
		public AssetPool build() {
			return this;
		}
		
		@Override
		public AssetPool.AssetPoolBuilder toBuilder() {
			AssetPool.AssetPoolBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetPool.AssetPoolBuilder builder) {
			ofNullable(getVersionHistoryModel()).ifPresent(builder::setVersionHistoryModel);
			ofNullable(getInitialFactor()).ifPresent(builder::setInitialFactor);
			ofNullable(getCurrentFactor()).ifPresent(builder::setCurrentFactor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetPool _that = getType().cast(o);
		
			if (!Objects.equals(versionHistoryModel, _that.getVersionHistoryModel())) return false;
			if (!Objects.equals(initialFactor, _that.getInitialFactor())) return false;
			if (!Objects.equals(currentFactor, _that.getCurrentFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (versionHistoryModel != null ? versionHistoryModel.hashCode() : 0);
			_result = 31 * _result + (initialFactor != null ? initialFactor.hashCode() : 0);
			_result = 31 * _result + (currentFactor != null ? currentFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetPool {" +
				"versionHistoryModel=" + this.versionHistoryModel + ", " +
				"initialFactor=" + this.initialFactor + ", " +
				"currentFactor=" + this.currentFactor +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetPool  ***********************/
	class AssetPoolBuilderImpl implements AssetPool.AssetPoolBuilder {
	
		protected VersionHistoryModel.VersionHistoryModelBuilder versionHistoryModel;
		protected BigDecimal initialFactor;
		protected BigDecimal currentFactor;
	
		public AssetPoolBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("versionHistoryModel")
		public VersionHistoryModel.VersionHistoryModelBuilder getVersionHistoryModel() {
			return versionHistoryModel;
		}
		
		@Override
		public VersionHistoryModel.VersionHistoryModelBuilder getOrCreateVersionHistoryModel() {
			VersionHistoryModel.VersionHistoryModelBuilder result;
			if (versionHistoryModel!=null) {
				result = versionHistoryModel;
			}
			else {
				result = versionHistoryModel = VersionHistoryModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialFactor")
		public BigDecimal getInitialFactor() {
			return initialFactor;
		}
		
		@Override
		@RosettaAttribute("currentFactor")
		public BigDecimal getCurrentFactor() {
			return currentFactor;
		}
		
		@Override
		@RosettaAttribute("versionHistoryModel")
		public AssetPool.AssetPoolBuilder setVersionHistoryModel(VersionHistoryModel versionHistoryModel) {
			this.versionHistoryModel = versionHistoryModel==null?null:versionHistoryModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("initialFactor")
		public AssetPool.AssetPoolBuilder setInitialFactor(BigDecimal initialFactor) {
			this.initialFactor = initialFactor==null?null:initialFactor;
			return this;
		}
		@Override
		@RosettaAttribute("currentFactor")
		public AssetPool.AssetPoolBuilder setCurrentFactor(BigDecimal currentFactor) {
			this.currentFactor = currentFactor==null?null:currentFactor;
			return this;
		}
		
		@Override
		public AssetPool build() {
			return new AssetPool.AssetPoolImpl(this);
		}
		
		@Override
		public AssetPool.AssetPoolBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetPool.AssetPoolBuilder prune() {
			if (versionHistoryModel!=null && !versionHistoryModel.prune().hasData()) versionHistoryModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getVersionHistoryModel()!=null && getVersionHistoryModel().hasData()) return true;
			if (getInitialFactor()!=null) return true;
			if (getCurrentFactor()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetPool.AssetPoolBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetPool.AssetPoolBuilder o = (AssetPool.AssetPoolBuilder) other;
			
			merger.mergeRosetta(getVersionHistoryModel(), o.getVersionHistoryModel(), this::setVersionHistoryModel);
			
			merger.mergeBasic(getInitialFactor(), o.getInitialFactor(), this::setInitialFactor);
			merger.mergeBasic(getCurrentFactor(), o.getCurrentFactor(), this::setCurrentFactor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetPool _that = getType().cast(o);
		
			if (!Objects.equals(versionHistoryModel, _that.getVersionHistoryModel())) return false;
			if (!Objects.equals(initialFactor, _that.getInitialFactor())) return false;
			if (!Objects.equals(currentFactor, _that.getCurrentFactor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (versionHistoryModel != null ? versionHistoryModel.hashCode() : 0);
			_result = 31 * _result + (initialFactor != null ? initialFactor.hashCode() : 0);
			_result = 31 * _result + (currentFactor != null ? currentFactor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetPoolBuilder {" +
				"versionHistoryModel=" + this.versionHistoryModel + ", " +
				"initialFactor=" + this.initialFactor + ", " +
				"currentFactor=" + this.currentFactor +
			'}';
		}
	}
}
