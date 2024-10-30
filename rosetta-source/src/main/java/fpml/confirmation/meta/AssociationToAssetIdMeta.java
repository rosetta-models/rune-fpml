package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssociationToAssetId;
import fpml.confirmation.validation.AssociationToAssetIdTypeFormatValidator;
import fpml.confirmation.validation.AssociationToAssetIdValidator;
import fpml.confirmation.validation.exists.AssociationToAssetIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AssociationToAssetId.class)
public class AssociationToAssetIdMeta implements RosettaMetaData<AssociationToAssetId> {

	@Override
	public List<Validator<? super AssociationToAssetId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssociationToAssetId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AssociationToAssetId> validator() {
		return new AssociationToAssetIdValidator();
	}

	@Override
	public Validator<? super AssociationToAssetId> typeFormatValidator() {
		return new AssociationToAssetIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssociationToAssetId, Set<String>> onlyExistsValidator() {
		return new AssociationToAssetIdOnlyExistsValidator();
	}
}
