package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.UnderlyingAssetTranche;
import fpml.confirmation.validation.UnderlyingAssetTrancheTypeFormatValidator;
import fpml.confirmation.validation.UnderlyingAssetTrancheValidator;
import fpml.confirmation.validation.exists.UnderlyingAssetTrancheOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=UnderlyingAssetTranche.class)
public class UnderlyingAssetTrancheMeta implements RosettaMetaData<UnderlyingAssetTranche> {

	@Override
	public List<Validator<? super UnderlyingAssetTranche>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnderlyingAssetTranche, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super UnderlyingAssetTranche> validator() {
		return new UnderlyingAssetTrancheValidator();
	}

	@Override
	public Validator<? super UnderlyingAssetTranche> typeFormatValidator() {
		return new UnderlyingAssetTrancheTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnderlyingAssetTranche, Set<String>> onlyExistsValidator() {
		return new UnderlyingAssetTrancheOnlyExistsValidator();
	}
}
